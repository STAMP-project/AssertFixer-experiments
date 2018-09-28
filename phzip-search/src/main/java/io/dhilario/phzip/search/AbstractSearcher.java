/*
 * Copyright (c) 2018 Dann Ryan Hilario
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package io.dhilario.phzip.search;

import java.io.IOException;
import java.util.List;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.RAMDirectory;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;

/**
 * Implements boiler-plate codes for preparing Lucene components and leaves
 * its subclasses for the actual search concrete implementation.
 * @param <T> the scope type.
 */
public abstract class AbstractSearcher<T> {

  /**
   * The number of documents to show in the search result.
   */
  static final int NUMBER_OF_DOCS_TO_SHOW = 10;

  /**
   * The type of entity to store in the index.
   */
  enum Type {
    /**
     * Use if the document field to store in the index is a province.
     */
    PROVINCE,
    /**
     * Use if the document field to store in the index is a state.
     */
    STATE,
    /**
     * Use if the document field to store in the index is a region.
     */
    REGION,
    /**
     * Use if the document field to store in the index is a city.
     */
    CITY,
    /**
     * Use if the document field to store in the index is a location.
     */
    LOCATION;
  }

  /**
   * List of available {@code Province}.
   */
  private final List<Province> provinces;
  /**
   * Memory directory.
   */
  private final RAMDirectory directory;
  /**
   * Lucene's index searcher.
   */
  private final IndexSearcher idxSearcher;

  /**
   * Constructor that accepts provinces API.
   * @param prov the {@code Provinces} API
   * @throws IOException if error is encountered in {@code IndexWriter}
   */
  protected AbstractSearcher(final Provinces prov) throws IOException {

    this.provinces = prov.getAllProvinces(SortDirection.ASC, true);
    this.directory = new RAMDirectory();
    Analyzer analyzer = new StandardAnalyzer();
    IndexWriterConfig config = new IndexWriterConfig(analyzer);

    IndexWriter indexWriter = new IndexWriter(directory, config);

    if (this.getClass() == ProvinceScopeSearcher.class) {
      indexDocuments(indexWriter, this.provinces);
    }

    indexWriter.close();

    idxSearcher = new IndexSearcher(DirectoryReader.open(directory));
  }

  /**
   * Populate Lucene's {@code MultiFieldQueryParser} parse method based on
   * the PhZip's searchable attributes.
   * @param queryTerms the query terms
   * @return a Lucene {@code Query} object based on the result of the query
   * @throws ParseException if an error occurs during parsing
   */
  final Query createQuery(final String queryTerms) throws ParseException {

    return MultiFieldQueryParser.parse(queryTerms,
        new String[] {"name", "abbreviation", "alt", "zipcode"},
        new Occur[] {Occur.SHOULD, Occur.SHOULD, Occur.SHOULD, Occur.SHOULD},
        new StandardAnalyzer());

  }

  /**
   * Method that stores documents to Lucene's index.
   * @param indexWriter the {@code IndexWriter} object
   * @param prov the Province API
   * @throws IOException if error occurs during building of index
   */
  private void indexDocuments(final IndexWriter indexWriter,
      final List<Province> prov) throws IOException {

    for (Province province : prov) {

      Document provinceDoc = new Document();

      provinceDoc.add(new StoredField("type", Type.PROVINCE.toString()));
      provinceDoc.add(new StoredField("id", province.getId()));
      provinceDoc.add(new TextField("name", province.getName(), Field.Store.YES));
      if (province.getAbbreviation() != null) {
        provinceDoc.add(new TextField("abbreviation", province.getAbbreviation(),
            Field.Store.YES));
      }
      if (province.getAlt() != null && !province.getAlt().isEmpty()) {
        for (String alt : province.getAlt()) {
          provinceDoc.add(new TextField("alt", alt, Field.Store.YES));
        }
      }

      indexWriter.addDocument(provinceDoc);

      List<City> cities = province.getCities();

      if (cities == null || cities.isEmpty()) {
        continue;
      }

      for (City city : cities) {

        Document cityDoc = new Document();

        cityDoc.add(new StoredField("type", Type.CITY.toString()));
        cityDoc.add(new StoredField("provinceId", province.getId()));
        cityDoc.add(new StoredField("id", city.getId()));
        cityDoc.add(new TextField("name", city.getName(), Field.Store.YES));
        if (city.getZipcode() != null) {
          cityDoc.add(new TextField("zipcode", city.getZipcode(),
              Field.Store.YES));
        }
        if (city.getAbbreviation() != null) {
          cityDoc.add(new TextField("abbreviation", city.getAbbreviation(),
              Field.Store.YES));
        }
        if (city.getAlt() != null && !city.getAlt().isEmpty()) {
          for (String alt : city.getAlt()) {
            cityDoc.add(new TextField("alt", alt, Field.Store.YES));
          }
        }

        indexWriter.addDocument(cityDoc);

        List<Location> locations = city.getLocation();

        if (locations == null || locations.isEmpty()) {
          continue;
        }

        for (Location location : locations) {

          Document ldoc = new Document();

          ldoc.add(new StoredField("type", Type.LOCATION.toString()));
          ldoc.add(new StoredField("provinceId", province.getId()));
          ldoc.add(new StoredField("cityId", city.getId()));
          ldoc.add(new StoredField("id", location.getId()));

          // phone purposedly unindexed
          ldoc.add(new TextField("name", location.getName(),
              Field.Store.YES));
          ldoc.add(new TextField("zipcode", location.getZipcode(),
              Field.Store.YES));

          if (location.getAlt() != null && !location.getAlt().isEmpty()) {
            for (String alt : location.getAlt()) {
              ldoc.add(new TextField("alt", alt, Field.Store.YES));
            }
          }

          indexWriter.addDocument(ldoc);
        }
      }
    }
  }

  /**
   * Returns the {@code Provinces} API.
   * @return provinces the {@code Provinces} API
   */
  protected final List<Province> getProvinces() {
    return provinces;
  }

  /**
   * Returns {@code RAMDirectory}.
   * @return directory the Lucene directory.
   */
  protected final RAMDirectory getDirectory() {
    return directory;
  }

  /**
   * Returns Lucene's {@code IndexSearcher}.
   * @return idxSearcher the Lucene index
   */
  protected final IndexSearcher getIndexSearcher() {
    return idxSearcher;
  }

  /**
   * The abstract method for search.
   * @param queryTerms the query terms
   * @return the list of entity that matches the query search
   * @throws IOException if an error is encountered during deserialization
   *         of the entity
   * @throws ParseException if an error occur during parsing of query terms
   */
  public abstract List<T> search(final String queryTerms)
      throws IOException, ParseException;

}

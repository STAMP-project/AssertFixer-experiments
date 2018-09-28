/*
 * Copyright (c) 2018 Dann Ryan Hilario
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package io.dhilario.phzip.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;

/**
 * Implementation of searcher with {@code Province} level scope.
 */
public class ProvinceScopeSearcher extends AbstractSearcher<Province> {

  /**
   * Constructor that accepts the {@code Provinces} API.
   *
   * @param provinces the {@code Provinces} API
   * @throws IOException if there's an error in JSON deserialization of Provinces.
   */
  public ProvinceScopeSearcher(final Provinces provinces) throws IOException {
    super(provinces);
  }

  @Override
  public final List<Province> search(final String queryTerms) throws IOException, ParseException {

    List<Province> resultList = new ArrayList<Province>();

    IndexSearcher idxSearcher = getIndexSearcher();
    List<Province> provinces = getProvinces();

    Query query = createQuery(queryTerms);
    TopDocs docs = idxSearcher.search(query, NUMBER_OF_DOCS_TO_SHOW);

    for (ScoreDoc doc : docs.scoreDocs) {

      Document thisDoc = idxSearcher.doc(doc.doc);

      Province matchedProvince = null;

      if (thisDoc.get("type").equals(Type.PROVINCE.toString())) {

        matchedProvince = findProvinceMatch(thisDoc, provinces, "id");

      } else if (thisDoc.get("type").equals(Type.CITY.toString())) {

        Province deepCopyOfProvince = findProvinceMatch(thisDoc, provinces, "provinceId");

        // shallow copy province to filter cities that didn't matched.
        matchedProvince = shallowCopyProvince(deepCopyOfProvince);
        City matchedCity = findCityMatch(thisDoc, deepCopyOfProvince, "id");
        matchedProvince.setCities(Collections.singletonList(matchedCity));

      } else if (thisDoc.get("type").equals(Type.LOCATION.toString())) {

        Province deepCopyOfProvince = findProvinceMatch(thisDoc, provinces, "provinceId");

        // shallow copy province to filter cities that didn't matched.
        matchedProvince = shallowCopyProvince(deepCopyOfProvince);
        City deepCopyOfCity = findCityMatch(thisDoc, deepCopyOfProvince, "cityId");
        // shallow copy city to filter locations that didn't matched.
        City shallowCopyOfCity = shallowCopyCity(deepCopyOfCity);
        matchedProvince.setCities(Collections.singletonList(shallowCopyOfCity));

        Location matchedLocation = deepCopyOfCity.getLocation().stream()
            .filter(c -> c.getId().equals(Integer.valueOf(thisDoc.get("id")))).findFirst().get();

        shallowCopyOfCity.setLocation(Collections.singletonList(matchedLocation));
      }

      resultList.add(matchedProvince);
    }

    return resultList;
  }

  /**
   * Finds city based on Lucene {@code Document} and deep copy of {@code Province}.
   *
   * @param thisDoc the Lucene {@code Document}
   * @param deepCopyOfProvince the deep copy of the {@code Province}
   * @param idTag the Id Tag
   * @return the matching {@code City}
   */
  private City findCityMatch(final Document thisDoc, final Province deepCopyOfProvince,
      final String idTag) {

    City deepCopyOfCities = deepCopyOfProvince.getCities().stream()
        .filter(c -> c.getId().equals(Integer.valueOf(thisDoc.get(idTag)))).findFirst().get();
    return deepCopyOfCities;
  }

  /**
   * Finds province based on Lucene {@code Document} and list of {@code Province}.
   *
   * @param thisDoc the Lucene {@code Document}
   * @param provinces list of {@code Province}
   * @param idTag the Id Tag
   * @return the matching {@code Province}
   */
  private Province findProvinceMatch(final Document thisDoc, final List<Province> provinces,
      final String idTag) {
    Province provinceId = new Province(Integer.valueOf(thisDoc.get(idTag)));
    Province deepCopyOfProvince = provinces.get(provinces.indexOf(provinceId));
    return deepCopyOfProvince;
  }

  /**
   * Extract shallow copy of {@code Province}.
   *
   * @param deepCopyOfProvince the deep copy of the {@code Province}
   * @return matchedProvince the shallow copy of the {@code Province}
   */
  private Province shallowCopyProvince(final Province deepCopyOfProvince) {
    Province matchedProvince = new Province();
    matchedProvince.setId(deepCopyOfProvince.getId());
    matchedProvince.setName(deepCopyOfProvince.getName());
    matchedProvince.setAbbreviation(deepCopyOfProvince.getAbbreviation());
    matchedProvince.setAlt(deepCopyOfProvince.getAlt());

    return matchedProvince;
  }

  /**
   * Extract shallow copy of {@code City}.
   *
   * @param deepCopyOfCity the deep copy of the {@code City}
   * @return matchedCity the shallow copy of the {@code City}
   */
  private City shallowCopyCity(final City deepCopyOfCity) {
    City matchedCity = new City(deepCopyOfCity.getId());
    matchedCity.setName(deepCopyOfCity.getName());
    matchedCity.setAbbreviation(deepCopyOfCity.getAbbreviation());
    matchedCity.setAlt(deepCopyOfCity.getAlt());
    matchedCity.setZipcode(deepCopyOfCity.getZipcode());

    return matchedCity;
  }
}

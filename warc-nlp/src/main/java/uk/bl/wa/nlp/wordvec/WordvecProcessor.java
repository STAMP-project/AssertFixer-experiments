package uk.bl.wa.nlp.wordvec;

import java.io.FileReader;
import java.util.Collection;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordvecProcessor {

    private static Logger log = LoggerFactory.getLogger(WordvecProcessor.class);

    public static void main(String[] args) throws Exception {

        SentenceIterator iter = new StanfordSentenceIterator(
                new FileReader("src/test/resources/Mona_Lisa.txt"));

        // Use Stanford NLP sentence splitter:

        // Split on white spaces in the line to get words
        TokenizerFactory t = new DefaultTokenizerFactory();
        t.setTokenPreProcessor(new CommonPreprocessor());

        log.info("Building model....");
        Word2Vec vec = new Word2Vec.Builder().minWordFrequency(5).iterations(1)
                .layerSize(100).seed(42).windowSize(5).iterate(iter)
                .tokenizerFactory(t).build();

        log.info("Fitting Word2Vec model....");
        vec.fit();

        log.info("Writing word vectors to text file....");

        // Write word vectors
        WordVectorSerializer.writeWordVectors(vec, "pathToWriteto.txt");
        WordVectorSerializer.writeFullModel(vec, "pathToWriteto.model");

        log.info("Closest Words:");
        Collection<String> lst = vec.wordsNearest("french", 10);
        System.out.println(lst);
        // UiServer server = UiServer.getInstance();
        // System.out.println("Started on port " + server.getPort());


    }
}

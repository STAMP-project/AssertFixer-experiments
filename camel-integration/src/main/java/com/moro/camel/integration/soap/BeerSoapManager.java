package com.moro.camel.integration.soap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moro.camel.integration.factory.EndpointFactory;
import com.moro.model.Beer;
import com.moro.model.BeerDto;
import com.moro.soap.beersoapservice.BeerEndpoint;
import org.apache.camel.Exchange;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

public class BeerSoapManager {

    private BeerEndpoint beerEndpoint;
    private ModelMapper modelMapper;
    private ObjectMapper objectMapper;

    @Autowired
    public BeerSoapManager(EndpointFactory factory,
                           ModelMapper modelMapper,
                           ObjectMapper objectMapper) throws MalformedURLException {
        beerEndpoint = factory.createBeerEndpoint();
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public void addBeer(Exchange exchange) throws IOException {
        Beer beer = modelMapper.map(beerEndpoint.addBeer(
                objectMapper.readValue(
                        exchange.getIn().getBody(String.class),
                        com.moro.soap.beersoapservice.Beer.class)), Beer.class);

        exchange.getOut().setBody(beer);
    }

    public void deleteBeerById(Exchange exchange, int beerId){

        beerEndpoint.deleteBeerById(beerId);

        exchange.getOut().setBody("");
    }

    public void getAllBeers(Exchange exchange){
        Collection<BeerDto> beers = new ArrayList<>();
        for (com.moro.soap.beersoapservice.BeerDto beerDto : beerEndpoint.getAllBeers()) {
            beers.add(modelMapper.map(beerDto, BeerDto.class));
        }

        exchange.getOut().setBody(beers);
    }

    public void getBeerById(Exchange exchange, int beerId){
        exchange.getOut().setBody(
                modelMapper.map(beerEndpoint.getBeerById(beerId), Beer.class)
        );
    }

    public void updateBeer(Exchange exchange) throws IOException {
        beerEndpoint.updateBeer(
                objectMapper.readValue(
                        exchange.getIn().getBody(String.class),
                        com.moro.soap.beersoapservice.Beer.class)
        );
        exchange.getOut().setBody("");
    }
}

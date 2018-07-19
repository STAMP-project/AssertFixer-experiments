package com.brave.tradebravely.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.brave.tradebravely.domain.Tax;
import com.brave.tradebravely.service.TaxService;
import com.brave.tradebravely.web.rest.errors.BadRequestAlertException;
import com.brave.tradebravely.web.rest.util.HeaderUtil;
import com.brave.tradebravely.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Tax.
 */
@RestController
@RequestMapping("/api")
public class TaxResource {

    private final Logger log = LoggerFactory.getLogger(TaxResource.class);

    private static final String ENTITY_NAME = "tax";

    private final TaxService taxService;

    public TaxResource(TaxService taxService) {
        this.taxService = taxService;
    }

    /**
     * POST  /taxes : Create a new tax.
     *
     * @param tax the tax to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tax, or with status 400 (Bad Request) if the tax has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/taxes")
    @Timed
    public ResponseEntity<Tax> createTax(@RequestBody Tax tax) throws URISyntaxException {
        log.debug("REST request to save Tax : {}", tax);
        if (tax.getId() != null) {
            throw new BadRequestAlertException("A new tax cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Tax result = taxService.save(tax);
        return ResponseEntity.created(new URI("/api/taxes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /taxes : Updates an existing tax.
     *
     * @param tax the tax to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tax,
     * or with status 400 (Bad Request) if the tax is not valid,
     * or with status 500 (Internal Server Error) if the tax couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/taxes")
    @Timed
    public ResponseEntity<Tax> updateTax(@RequestBody Tax tax) throws URISyntaxException {
        log.debug("REST request to update Tax : {}", tax);
        if (tax.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Tax result = taxService.save(tax);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tax.getId().toString()))
            .body(result);
    }

    /**
     * GET  /taxes : get all the taxes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of taxes in body
     */
    @GetMapping("/taxes")
    @Timed
    public ResponseEntity<List<Tax>> getAllTaxes(Pageable pageable) {
        log.debug("REST request to get a page of Taxes");
        Page<Tax> page = taxService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/taxes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /taxes/:id : get the "id" tax.
     *
     * @param id the id of the tax to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tax, or with status 404 (Not Found)
     */
    @GetMapping("/taxes/{id}")
    @Timed
    public ResponseEntity<Tax> getTax(@PathVariable String id) {
        log.debug("REST request to get Tax : {}", id);
        Optional<Tax> tax = taxService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tax);
    }

    /**
     * DELETE  /taxes/:id : delete the "id" tax.
     *
     * @param id the id of the tax to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/taxes/{id}")
    @Timed
    public ResponseEntity<Void> deleteTax(@PathVariable String id) {
        log.debug("REST request to delete Tax : {}", id);
        taxService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}

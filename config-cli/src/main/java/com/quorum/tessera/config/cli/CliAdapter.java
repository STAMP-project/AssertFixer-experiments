package com.quorum.tessera.config.cli;

public interface CliAdapter {

    CliResult execute(String... args) throws Exception;

}

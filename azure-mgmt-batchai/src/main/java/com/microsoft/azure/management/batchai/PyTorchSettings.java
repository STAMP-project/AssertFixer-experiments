/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * pyTorch job settings.
 */
public class PyTorchSettings {
    /**
     * Python script file path.
     * The python script to execute.
     */
    @JsonProperty(value = "pythonScriptFilePath", required = true)
    private String pythonScriptFilePath;

    /**
     * Python interpreter path.
     * The path to the Python interpreter.
     */
    @JsonProperty(value = "pythonInterpreterPath")
    private String pythonInterpreterPath;

    /**
     * Command line arguments.
     * Command line arguments that need to be passed to the python script.
     */
    @JsonProperty(value = "commandLineArgs")
    private String commandLineArgs;

    /**
     * Process count.
     * Number of processes to launch for the job execution. The default value
     * for this property is equal to nodeCount property.
     */
    @JsonProperty(value = "processCount")
    private Integer processCount;

    /**
     * Communication backend.
     * Type of the communication backend for distributed jobs. Valid values are
     * 'TCP', 'Gloo' or 'MPI'. Not required for non-distributed jobs.
     */
    @JsonProperty(value = "communicationBackend")
    private String communicationBackend;

    /**
     * Get the python script to execute.
     *
     * @return the pythonScriptFilePath value
     */
    public String pythonScriptFilePath() {
        return this.pythonScriptFilePath;
    }

    /**
     * Set the python script to execute.
     *
     * @param pythonScriptFilePath the pythonScriptFilePath value to set
     * @return the PyTorchSettings object itself.
     */
    public PyTorchSettings withPythonScriptFilePath(String pythonScriptFilePath) {
        this.pythonScriptFilePath = pythonScriptFilePath;
        return this;
    }

    /**
     * Get the path to the Python interpreter.
     *
     * @return the pythonInterpreterPath value
     */
    public String pythonInterpreterPath() {
        return this.pythonInterpreterPath;
    }

    /**
     * Set the path to the Python interpreter.
     *
     * @param pythonInterpreterPath the pythonInterpreterPath value to set
     * @return the PyTorchSettings object itself.
     */
    public PyTorchSettings withPythonInterpreterPath(String pythonInterpreterPath) {
        this.pythonInterpreterPath = pythonInterpreterPath;
        return this;
    }

    /**
     * Get command line arguments that need to be passed to the python script.
     *
     * @return the commandLineArgs value
     */
    public String commandLineArgs() {
        return this.commandLineArgs;
    }

    /**
     * Set command line arguments that need to be passed to the python script.
     *
     * @param commandLineArgs the commandLineArgs value to set
     * @return the PyTorchSettings object itself.
     */
    public PyTorchSettings withCommandLineArgs(String commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
        return this;
    }

    /**
     * Get number of processes to launch for the job execution. The default value for this property is equal to nodeCount property.
     *
     * @return the processCount value
     */
    public Integer processCount() {
        return this.processCount;
    }

    /**
     * Set number of processes to launch for the job execution. The default value for this property is equal to nodeCount property.
     *
     * @param processCount the processCount value to set
     * @return the PyTorchSettings object itself.
     */
    public PyTorchSettings withProcessCount(Integer processCount) {
        this.processCount = processCount;
        return this;
    }

    /**
     * Get type of the communication backend for distributed jobs. Valid values are 'TCP', 'Gloo' or 'MPI'. Not required for non-distributed jobs.
     *
     * @return the communicationBackend value
     */
    public String communicationBackend() {
        return this.communicationBackend;
    }

    /**
     * Set type of the communication backend for distributed jobs. Valid values are 'TCP', 'Gloo' or 'MPI'. Not required for non-distributed jobs.
     *
     * @param communicationBackend the communicationBackend value to set
     * @return the PyTorchSettings object itself.
     */
    public PyTorchSettings withCommunicationBackend(String communicationBackend) {
        this.communicationBackend = communicationBackend;
        return this;
    }

}

package io.cloudslang.lang.compiler.validator;

import io.cloudslang.lang.compiler.modeller.result.ExecutableModellingResult;
import io.cloudslang.lang.compiler.modeller.transformers.Transformer;
import io.cloudslang.lang.compiler.parser.model.ParsedSlang;
import io.cloudslang.lang.entities.bindings.Argument;
import io.cloudslang.lang.entities.bindings.Input;
import io.cloudslang.lang.entities.bindings.Output;
import io.cloudslang.lang.entities.bindings.Result;
import java.util.List;
import java.util.Map;

/**
 * User: bancl
 * Date: 6/17/2016
 */
public interface PreCompileValidator {

    String validateExecutableRawData(ParsedSlang parsedSlang, Map<String, Object> executableRawData, List<RuntimeException> errors);

    List<Map<String, Map<String, Object>>> validateWorkflowRawData(ParsedSlang parsedSlang, Map<String, Object> executableRawData, List<RuntimeException> errors);

    ExecutableModellingResult validateResult(ParsedSlang parsedSlang, Map<String, Object> executableRawData, ExecutableModellingResult result);

    List<RuntimeException> checkKeyWords(String dataLogicalName, String parentProperty, Map<String, Object> rawData, List<Transformer> allRelevantTransformers, List<String> additionalValidKeyWords, List<List<String>> constraintGroups);

    Map<String, Map<String, Object>> validateOnFailurePosition(List<Map<String, Map<String, Object>>> workFlowRawData, String execName, List<RuntimeException> errors);

    void validateNoDuplicateInputs(List<Input> inputs, Input element);

    void validateNoDuplicateStepInputs(List<Argument> inputs, Argument element);

    void validateNoDuplicateOutputs(List<Output> outputs, Output element);

    void validateNoDuplicateResults(List<Result> results, Result element);

    void validateResultsSection(Map<String, Object> executableRawData, String artifact, List<RuntimeException> errors);
}

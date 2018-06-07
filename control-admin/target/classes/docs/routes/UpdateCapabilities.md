 ActionRoute to update the capabilities of layers
 Can be called with 'id' parameter where the value is a layer id.
 If 'id' can not be parsed into an integer then this action route
 will try to update the capabilities of ALL layers.

 Responds with a JSON object describing the result.
 The result contains two keys, "success" and "error".

 "success" is an array of the ids of the layers whose
 capabilities were succesfully updated.

 "error" is an object consisting of multiple
 "{layerId}": "{errorMsg}" entries each describing what
 went wrong with updating that particular layer.

 Both "success" and "error" might be empty

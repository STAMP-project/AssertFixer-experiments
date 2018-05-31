
# SmallMoleculeEvidence

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**prefix** | [**PrefixEnum**](#PrefixEnum) |  | 
**headerPrefix** | [**HeaderPrefixEnum**](#HeaderPrefixEnum) |  | 
**smeId** | **String** |  |  [optional]
**evidenceInputId** | **String** |  |  [optional]
**databaseIdentifier** | **String** |  |  [optional]
**chemicalFormula** | **String** |  |  [optional]
**smiles** | **String** |  |  [optional]
**inchi** | **String** |  |  [optional]
**chemicalName** | **String** |  |  [optional]
**uri** | **String** |  |  [optional]
**derivatizedForm** | [**Parameter**](Parameter.md) |  |  [optional]
**adductIon** | **String** |  |  [optional]
**expMassToCharge** | **Double** |  |  [optional]
**charge** | **Integer** |  |  [optional]
**theoreticalMassToCharge** | **Double** |  |  [optional]
**spectraRef** | [**List&lt;SpectraRef&gt;**](SpectraRef.md) |  |  [optional]
**identificationMethod** | [**Parameter**](Parameter.md) |  |  [optional]
**msLevel** | [**Parameter**](Parameter.md) |  |  [optional]
**idConfidenceMeasure** | **List&lt;Double&gt;** |  |  [optional]
**rank** | **Integer** |  |  [optional]
**opt** | [**List&lt;OptColumnMapping&gt;**](OptColumnMapping.md) |  |  [optional]
**comment** | [**List&lt;Comment&gt;**](Comment.md) |  |  [optional]


<a name="PrefixEnum"></a>
## Enum: PrefixEnum
Name | Value
---- | -----
SME | &quot;SME&quot;


<a name="HeaderPrefixEnum"></a>
## Enum: HeaderPrefixEnum
Name | Value
---- | -----
SEH | &quot;SEH&quot;




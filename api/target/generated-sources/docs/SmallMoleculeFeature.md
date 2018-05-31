
# SmallMoleculeFeature

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**prefix** | [**PrefixEnum**](#PrefixEnum) |  | 
**headerPrefix** | [**HeaderPrefixEnum**](#HeaderPrefixEnum) |  | 
**smfId** | **String** |  | 
**smeIdRefs** | **List&lt;String&gt;** |  | 
**smeIdRefAmbiguityCode** | **Integer** |  |  [optional]
**adductIon** | **String** |  |  [optional]
**isotopomer** | [**Parameter**](Parameter.md) |  |  [optional]
**expMassToCharge** | **Double** |  |  [optional]
**charge** | **Integer** |  |  [optional]
**retentionTimeInSeconds** | **Double** |  |  [optional]
**retentionTimeInSecondsStart** | **Double** |  |  [optional]
**retentionTimeInSecondsEnd** | **Double** |  |  [optional]
**abundanceAssay** | **List&lt;Double&gt;** |  |  [optional]
**opt** | [**List&lt;OptColumnMapping&gt;**](OptColumnMapping.md) |  |  [optional]
**comment** | [**List&lt;Comment&gt;**](Comment.md) |  |  [optional]


<a name="PrefixEnum"></a>
## Enum: PrefixEnum
Name | Value
---- | -----
SMF | &quot;SMF&quot;


<a name="HeaderPrefixEnum"></a>
## Enum: HeaderPrefixEnum
Name | Value
---- | -----
SFH | &quot;SFH&quot;




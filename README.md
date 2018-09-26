[![GitHub Downloads](https://img.shields.io/github/downloads/seppinho/haplogrep-cmd/total.svg?style=flat)](https://github.com/seppinho/haplogrep-cmd/releases)
[![Build Status](https://travis-ci.org/seppinho/haplogrep-cmd.svg?branch=master)](https://travis-ci.org/seppinho/haplogrep-cmd)

We provide a fast and free [haplogroup classification web service](https://haplogrep.uibk.ac.at/). You can upload your mtDNA profiles aligned to **rCRS** or **RSRS** and receive mitochondrial haplogroups in return. So far, HaploGrep and the updated HaploGrep 2 have been cited over 400 times (Google Scholar - June 2018). Please join our [HaploGrep Google User Group](https://groups.google.com/forum/#!forum/haplogrep) for future updates and ongoing discussions. 

## Download HaploGrep

We also provide a command line version for local usage. Download and execute the [latest release](https://github.com/seppinho/haplogrep-cmd/releases/download/v2.1.13/haplogrep-2.1.13.jar) (v2.1.13). 
 
      java -jar haplogrep-2.1.13.jar --in <input> --format vcf/hsd --out haplogroups.txt
   
HaploGrep only requires Java 8 and works on Windows, Linux and Mac.
 
## Additional Parameters      
* By default HaploGrep expects that your data is aligned against rCRS (which is included in the human references hg19 and hg38). If your data is aligned against RSRS, add the `--rsrs` parameter (Default: off). Please read [this blog post](http://haplogrep.uibk.ac.at/blog/rcrs-vs-rsrs-vs-hg19/) carefully before adding this option.
* To change the metric to Hamming Distance or Jaccard add the `--metric` parameter (Default: Kulczynski Measure).
* For adding additional output columns (e.g. found or remaining polymorphisms) please add the `--extend-report` flag (Default: off).
* The used Phylotree version can be changed using the `--phylotree` parameter (Default: 17).
* If your using genotyping arrays, please add the `--chip` parameter to limit the range to array SNPs only (Default: off, VCF only). 
To get the same behaviour for hsd files, please add **only** the variants to the range, which are included on the array or in the range you have sequenced (e.g. control region). Range can be sepearted by a semicolon `;`, both ranges and single positions are allowed (e.g. 1-576; 34).
* To output the complete path from rCRS root to your input sample use the `--lineage` parameter. (Default: off). We provide a textual format (`*.lineage.txt`) and a [Graphviz](http://www.graphviz.org/documentation/) DOT format. You can upload the HaploGrep `*.graphviz.txt` file [here](https://graphs.grevian.org/graph) or process it with the Graphviz library.

## File Formats
The recommended input format is [VCF](http://www.internationalgenome.org/wiki/Analysis/vcf4.0/). You can also specify your profiles in hsd format, which is a simple tab-delimited file format consisting of 4 columns (ID, Range, Haplogroup and Polymorphisms). For readability, the polymorphisms are also tab-delimited (so columns > 4). A hsd example can be found [here](https://raw.githubusercontent.com/seppinho/haplogrep-cmd/master/test-data/h100.hsd.txt). 

## mtDNA reference sequences
Several mtDNA references exist, HaploGrep supports rCRS and RSRS. Please checkout [our blog post](http://haplogrep.uibk.ac.at/blog/rcrs-vs-rsrs-vs-hg19/) to learn more about this topic.

## Genotyping arrays
If you are using HaploGrep for genotyping array data, please have a look at the `--chip` parameter above. 

## Heteroplasmies (VCF only)
Heteroplasmies are often stored as heterozygous genotypes (0/1). If a HF field (= Heteroplasmy Frequency of variant allele; introduced by MToolBox) is specified in the VCF header, we add variants with a HF > 0.96 to the input profile.

Please have a look at [mtDNA-Server](http://mtdna-server.uibk.ac.at) to check for heteroplasmies and contamination in your NGS data.   

## Blog
Check out our [blog](http://haplogrep.uibk.ac.at/blog/) regarding mtDNA topics.

## Cite use
If you use HaploGrep, please cite our latest [HaploGrep2 paper](http://nar.oxfordjournals.org/content/early/2016/04/15/nar.gkw233) in combination with [Phylotree 17](https://www.sciencedirect.com/science/article/pii/S1875176815302432). The first HaploGrep paper can be found [here](https://onlinelibrary.wiley.com/doi/abs/10.1002/humu.21382). 

## Contact
[Sebastian Schoenherr](mailto:sebastian.schoenherr@i-med.ac.at) ([@seppinho](https://twitter.com/seppinho)) and [Hansi Weissensteiner](mailto:hansi.weissensteiner@i-med.ac.at) ([@haansi](https://twitter.com/whansi)); Division of Genetic Epidemiology, Medical University of Innsbruck;

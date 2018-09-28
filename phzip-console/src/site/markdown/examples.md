# Examples

## Display help
```
java -jar phzip-console-0.2.0-jar-with-dependencies.jar -h

Option                            Description
------                            -----------
-h, --help                        Display this help information.
-c, --supported-countries         List supported countries.
-p, --list-provinces <[ph,us]>    List provinces of the specified country (default: ph)
-s, --list-states <[ph,us]>       List states of the specified country (default: us
```

## List supported countries
```
java -jar phzip-console-0.2.0-jar-with-dependencies.jar -c
Supported countries:
Code: 'ph', Name: 'Philippines'
Code: 'us', Name: 'United States'
```

## List states of chosen country
```
java -jar phzip-console-0.2.0-jar-with-dependencies.jar -s us
American Samoa
Arizona
Arkansas
California
Colorado
Connecticut
...
...
...
```

## List provinces of chosen country
```
java -jar phzip-console-0.2.0-jar-with-dependencies.jar -p ph
Metro Manila
Abra
Agusan del Norte
Agusan del Sur
Aklan
Albay
...
...
...
``` 
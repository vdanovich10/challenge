MASTERCARD CODE CHALLENGE

You’re asked to write a program using Spring Boot & Java (1.8 or above)<br/>
which determines if two cities are connected. Two cities are considered<br/>
connected if there’s a series of roads that can be traveled from one city<br/>
to another.<br/><br/>
List of roads is available in a file. The file contains a list of city<br/>
pairs (one pair per line, comma separated), which indicates that there’s a<br/>
road between those cities.<br/>
It will be deployed as a Spring Boot App and expose one endpoint:<br/>
<code>http://localhost:8080/connected?origin=city1&destination=city2</code><br/>
Your program should respond with ‘yes’ if city1 is connected to city2,<br/>
’no’ if city1 is not connected to city2.<br/><br/>
Any unexpected input should result in a ’no’ response.<br/><br/>
For Example:<br/>
city.txt content is:<br/>
Boston, New York<br/>
Philadelphia, Newark<br/>
Newark, Boston<br/>
Trenton, Albany<br/><br/>
http://localhost:8080/connected?origin=Boston&destination=Newark<br/>
Should return yes<br/><br/>
http://localhost:8080/connected?origin=Boston&destination=Philadelphia<br/>
Should return yes<br/><br/>
http://localhost:8080/connected?origin=Philadelphia&destination=Albany
Should return no
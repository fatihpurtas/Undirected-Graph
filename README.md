<h2>Assignment: Minimum Time Island Path</h2>
<p>In this part, you must implement your own graph data structure by taking inspiration from your textbook and use it to help solve the problem. You are not allowed to use any external library or `.jar` file. Any solutions without using a graph data structure will not be evaluated! (underline)</p>

<h3>Question 1 (25 points):</h3>
<p>You are a tour guide in a coastal city with <b>N</b> islands and <b>M</b> undirected boat routes to organize. Each island has a port that can function as a layover. The port can be in two states: loading and running. Passengers board boats in the loading state, and boats depart for the next island in the running state. All ports switch states (loading to running and vice versa) every <b>T</b> minutes.</p>
<p>At a port, if it's in loading state, you must wait for it to switch to running before continuing your journey. All ports are initially in the running state. It takes <b>C</b> minutes to travel through any boat route.</p>
<p>Find the lexicographically smallest path that takes the minimum amount of time (in minutes) to move from island <b>X</b> to island <b>Y</b>.</p>

<h4>Input:</h4>
<p>The first line contains four space-separated integers: <b>N</b>, <b>M</b>, <b>T</b>, and <b>C</b>. <b>N</b> denotes the number of islands, <b>M</b> denotes the number of connections between them, <b>T</b> denotes the time required for ports to change states, and <b>C</b> denotes the travel time between islands.</p>
<p>The next <b>M</b> lines contain two space-separated integers each: <b>U</b> and <b>V</b>, denoting a bidirectional boat route between island <b>U</b> and island <b>V</b>.</p>
<p>The next line contains two space-separated integers: <b>X</b>, the starting island, and <b>Y</b>, the destination island.</p>

<h5>Sample Input:</h5>
<pre><code>5 5 3 5
1 2
1 3
2 4
1 4
2 5
1 5
</code></pre>

<p>In this example, there are 5 islands and 5 bidirectional boat routes. The port state change time is 3 minutes, and the travel time between islands is 5 minutes. The following lines show the connections between islands and the starting and ending points.</p>
test
<h4>Output:</h4>
<p>The first line of the output should print an integer <b>K</b>, representing the number of islands you need to visit to reach island <b>Y</b> from island <b>X</b>.</p>
<p>The second line should print <b>K</b> space-separated integers denoting the path that takes the minimum amount of time (in minutes) to move from island <b>X</b> to island <b>Y</b>.</p>
<p>The last line should print the total travel time through the path from island <b>X</b> to island <b>Y</b>. There can be multiple paths; print the lexicographically smallest one and its total time.</p>

<h5>Sample Output:</h5>
<pre><code>3
1 2 5
11
</code></pre>

<h3>Question 2 (25 points):</h3>
<p>You are a tour guide organizing a city tour for your guests in a country with <b>M</b> cities and <b>N</b> undirected roads connecting them. The tour should begin at city <b>X</b>, include city <b>Y</b>, and end back at the starting point.</p>

<h4>Input:</h4>
<p>The first line contains two space-separated integers: <b>N</b>, the number of cities, and <b>M</b>, the number of connections between them.</p>
<p>The next <b>M</b> lines contain two space-separated integers each: <b>U</b> and <b>V</b>, denoting a bidirectional road between city <b>U</b> and city <b>V</b>.</p>
<p>The next line contains two space-separated integers: <b>X</b>, the starting city of the tour, and <b>Y</b>, the city that must be included in the tour.</p>

<h5>Sample Input:</h5>
<pre><code>6 6
1 2
1 3
2 4
3 4
3 5
5 6
1 4
</code></pre>

<p>In this example, there are 6 cities and 6 bidirectional paths between them. The following lines show the connections between cities and the starting and ending points for the tour.</p>

<h4>Output:</h4>
<p>Print <b>K</b> space-separated integers depicting the path for the tour, starting from city <b>X</b> and including city <b>Y</b>. There can be multiple paths; print the lexicographically smallest one.</p>

<h5>Sample Output:</h5>
<pre><code>1 2 3 4
</code></pre>

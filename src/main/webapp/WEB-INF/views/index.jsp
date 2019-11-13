<html>
<!--TODO: Move the css to resources/css  -->
<style type="text/css">
#backdrop {
	background: #2193b0; /* fallback for old browsers */
	background: -webkit-linear-gradient(to bottom, #6dd5ed, #2193b0);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to bottom, #6dd5ed, #2193b0);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

.center {
	line-height: 400px;
	height: 250px;
	text-align: center;
	font-size: 45px;
	color: white;
}

/* If the text has multiple lines, add the following: */
.centerp {
	text-align: center;
	color: white;
}

.bar {
	text-align: center;
	width: 50%;
	margin: 15px auto;
}
</style>
<body id="backdrop">
	<h2 class="center">Welcome Back, Nishant!!</h2>
	<p class="centerp">You have 4 ingredients in your inventory.</p>
	<div class="bar">
		<p>
			Overall health:
			<progress max="100" value="77"></progress>
		</p>
	</div>
	<div style="text-align: center">
		<!--
		<form action="addItem">
			<button type="submit" >Show more</button>
		</form> 
		-->
		<button onclick="window.location.href = 'addItem';">Show More</button>
	</div>
</body>
</html>
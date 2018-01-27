<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<html>
	<body>
	<h2>Person Collection</h2>
	<table border = "1">
		<tr bgcolor= "#3399ff">
			<th>NAME</th>
			<th>SURNAME</th>
			<th>HOMEADDR</th>
			<th>PHONE</th>
			<th>JOB</th>
		</tr>
		<xsl:for-each select = "PERSON">
		<tr>
			<td width="100"><xsl:value-of select = "NAME"/></td>
			<td width="100"><xsl:value-of select = "SURNAME"/></td>
			<td width="100"><xsl:value-of select = "HOMEADDR"/></td>
			<td width="100"><xsl:value-of select = "PHONE"/></td>
			<td width="100"><xsl:value-of select = "JOB"/></td>
		</tr>
		</xsl:for-each>
	</table>
	</body>
	</html>
</xsl:template>

</xsl:stylesheet>
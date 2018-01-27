<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="2.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
	<body>
	<h2>Company workers</h2>
	
	<xsl:for-each select="/company/POSITION">
	<table border = "2" width="70%">
		<tr>
			<th colspan="9" bgcolor="#00FF00"><xsl:value-of select = "@NAME"/></th>
		</tr>
		<tr>
			<th bgcolor="#9933ff">NAME</th>
			<th bgcolor="#FF0000">SURNAME</th>
			<th bgcolor="#9933ff">PHONE</th>
			<th bgcolor="#FF0000">HOMEADDR</th>
			<th bgcolor="#9933ff">PROGRAMING LANGUAGE</th>
			<th bgcolor="#FF0000">FOREIGN LANGUAGE</th>
		</tr>
		
		<xsl:if test="@NAME='programmer'">
			<xsl:for-each select="/company/POSITION[@NAME='programmer']/index">
			<tr>
				<td><xsl:value-of select="NAME"/></td>
				<td><xsl:value-of select="SURNAME"/></td>
				<td><xsl:value-of select="PHONE"/></td>
				<td><xsl:value-of select="HOMEADDR"/></td>
				<td><xsl:apply-templates select="PROGRAMING_LANGUAGE/KIND"/></td>
				<td><xsl:apply-templates select="FOREING_LANGUAGE"/></td>
			</tr>
			</xsl:for-each>
		</xsl:if>
		<xsl:if test="@NAME='tester'">
			<xsl:for-each select="/company/POSITION[@NAME='tester']/index">
			<tr>
				<td><xsl:value-of select="NAME"/></td>
				<td><xsl:value-of select="SURNAME"/></td>
				<td><xsl:value-of select="PHONE"/></td>
				<td><xsl:value-of select="HOMEADDR"/></td>
				<td><xsl:apply-templates select="PROGRAMING_LANGUAGE/KIND"/></td>
				<td><xsl:apply-templates select="FOREING_LANGUAGE"/></td>
			</tr>
			</xsl:for-each>
		</xsl:if>
		<xsl:if test="@NAME='manager'">
			<xsl:for-each select="/company/POSITION[@NAME='manager']/index">
			<tr>
				<td><xsl:value-of select="NAME"/></td>
				<td><xsl:value-of select="SURNAME"/></td>
				<td><xsl:value-of select="PHONE"/></td>
				<td><xsl:value-of select="HOMEADDR"/></td>
				<td><xsl:apply-templates select="PROGRAMING_LANGUAGE/KIND"/></td>
				<td><xsl:apply-templates select="FOREING_LANGUAGE"/></td>
			</tr>
			</xsl:for-each>
		</xsl:if>
	</table>
	</xsl:for-each>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>
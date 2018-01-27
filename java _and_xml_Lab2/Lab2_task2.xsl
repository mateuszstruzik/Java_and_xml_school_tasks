<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="2.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<html>
	<body>
	<h2>Salem Access Television</h2>
		
		<xsl:for-each select = "TVSCHEDULE/CHANNEL">

		<table border = "4" width="100%">
			
			<tr>
				<th>Channel</th>
			
			</tr>
			<tr>
				<td><xsl:value-of select = "@CHAN"/></td>
			</tr>
			<table border = "1" width="100%">
			<tr>
				<th>Banner</th>
			</tr>
			<tr>
				<td><xsl:value-of select = "BANNER"/></td>
			</tr>
			<table border = "1" width="100%">
			<tr>
				<th colspan="4">Day</th>
			</tr>
			<tr>
				<th width="20%">Date</th>
				<th width="10%">Time</th>
				<th width="40%">Title</th>
				<th width="30%">Description</th>
			</tr>
			<xsl:if test="@CHAN='3'">
              
				<xsl:for-each select = "/TVSCHEDULE/CHANNEL[@CHAN='3']/DAY">
					<tr>
					<td><xsl:value-of select = "DATE"/></td>
					<td><xsl:value-of select = "PROGRAMSLOT/TIME"/></td>
					<td><xsl:value-of select = "PROGRAMSLOT/TITLE"/></td>
					<td><xsl:value-of select = "PROGRAMSLOT/DESCRIPTION"/></td>
				</tr>
				</xsl:for-each>
			</xsl:if>
			<xsl:if test="@CHAN='15'">
            
				<xsl:for-each select = "/TVSCHEDULE/CHANNEL[@CHAN='15']/DAY">
				<tr>
					<td><xsl:value-of select = "DATE"/></td>
					<td><xsl:value-of select = "PROGRAMSLOT/TIME"/></td>
					<td><xsl:value-of select = "PROGRAMSLOT/TITLE"/></td>
					<td><xsl:value-of select = "PROGRAMSLOT/DESCRIPTION"/></td>
				</tr>
				</xsl:for-each>
			</xsl:if>
			
			</table>
			</table>
		</table>
		</xsl:for-each>
	</body>
	</html>

</xsl:template>
</xsl:stylesheet>
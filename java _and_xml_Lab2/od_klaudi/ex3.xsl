<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2 bgcolor="#DCDCDC">Future vision arch Managers</h2>
  <table border="2">
    <tr bgcolor="#DB7093">
      <th bgcolor="#FFE4E1">Name</th>
      <th bgcolor="#FFE4E1">Surname</th>	 
    </tr>
    <xsl:for-each select="company/department/manager">
    <tr>
      <td><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="surname"/></td>
	  </tr>
    </xsl:for-each>
  </table>
  <h2 bgcolor="#DCDCDC">Future vision arch Employees</h2>
  <table border="2">
    <tr bgcolor="#DB7093">
      <th>Name</th>
      <th>Surname</th>	 
    </tr>
    <xsl:for-each select="company/department/employee">
    <tr>
      <td><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="surname"/></td>
	  </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
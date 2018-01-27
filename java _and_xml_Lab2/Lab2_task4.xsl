<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="2.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
	<body>
	<h2>EMAIL system</h2>
	<xsl:for-each select="root">
	<p><xsl:text>Dear </xsl:text> <xsl:value-of select="MAIL_SYSTEM/NAME"/></p>
	<xsl:text>Your paper under title </xsl:text>
	<xsl:value-of select="MAIL_SYSTEM/TITLE"/>
	<xsl:text> that was register under nr ID</xsl:text>
	<xsl:value-of select="MAIL_SYSTEM/ID"/>
	<xsl:text> was successfully uploaded to a DepCoS-RELCOMEX</xsl:text>
	<p><xsl:text>conference</xsl:text></p>
	<p><xsl:text>You can check that the file is correctly uploaded by following this link: </xsl:text>
	<xsl:value-of select="MAIL_SYSTEM/LINK"/>
	</p>
	<p><xsl:text>Thanks for submitting to DepCoS-RELCOMEX 201x. Until the deadline, you</xsl:text></p>
	<p><xsl:text>can still update your information or transmit a revised file.</xsl:text></p>
	<p><xsl:text>Best regards,</xsl:text></p>
	<p><xsl:text>DepCoS-RELCOMEX chairs. </xsl:text></p>
	</xsl:for-each>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>

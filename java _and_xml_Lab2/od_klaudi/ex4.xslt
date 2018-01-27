<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <head>
	  <title>Mailing system</title>
	  <style type="text/css">
		tab1 { padding-left:4em;}
		h2 { text-align: center;}
		body { background-color: #FAEBD7;  animation-delay: 20s;}
	  </style>
  </head>
  <body>
  <h2>Content of the mail</h2>
	<h4> <font face="verdana" color="#708090"> Dear <xsl:value-of select="mail/name " /> <xsl:text> </xsl:text> <xsl:value-of select="mail/surname " /> <xsl:text>!</xsl:text> </font></h4>
	<div>
		<p><tab1>Your paper under title <xsl:value-of select="mail/title" /> that was register under nr ID <xsl:value-of select="mail/IDnumber" /> was successfully uploaded to a DepCoS-RELCOMEX conference. </tab1></p> 
		<p><tab1>You can check that the file is correctly uploaded by following this link: <i> <xsl:value-of select="mail/link" /> </i>. </tab1></p>
		<p><tab1>Thanks for submitting to DepCoS-RELCOMEX 201x. Until the deadline, you </tab1></p>
		<p><tab1>can still update your information or transmit a revised file.</tab1></p>	
		<p> Best regards, </p>
		<p><i>DepCoS-RELCOMEX chairs.  </i></p>	
	</div>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>


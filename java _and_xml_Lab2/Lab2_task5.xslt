<xsl:stylesheet version="2.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:content="http://purl.org/rss/1.0/modules/content/"
xmlns:atom="http://www.w3.org/2005/Atom"
xmlns:sy="http://purl.org/rss/1.0/modules/syndication/"
xmlns:dc="http://purl.org/dc/elements/1.1/"
xmlns:wfw="http://wellformedweb.org/CommentAPI/"
 xmlns:slash="http://purl.org/rss/1.0/modules/slash/">

<xsl:template match="/">
<html>
<body>
	<head>
	  <style type="text/css">
		<title>RSS from NYT</title>
		h2 { text-align: center;}
		tabl { fond-weig: bold;  animation-delay: 20s;}
		#one {
			background: #ffe6ff;
			left: 0
		}
		#two{
			color: orange;
			display: inline;
		}
	  </style>
	</head>
	<font face="Times New Roman" size="10px" color="#000000"><xsl:value-of select="rss/channel/title"/><xsl:text>   </xsl:text></font>
	<table border="3">
	<tr>
	<td style="font-style: italic">
	<p><xsl:value-of select="rss/channel/link"/></p>
	<p>Description: <xsl:value-of select="rss/channel/description"/></p>
	<p>Last Build: <xsl:value-of select="rss/channel/lastBuildDate"/></p>
	<p>Language: <xsl:value-of select="rss/channel/language"/></p>
	<p>Update period: <xsl:value-of select="rss/channel/sy:updatePeriod"/>, update frequency: 
	<xsl:value-of select="rss/channel/sy:updateFrequency"/></p>
	<p><xsl:value-of select="rss/channel/generator"/></p>
	</td>
	</tr>
	</table>
	
	<p>
	<img>
    <xsl:attribute name="src">
        <xsl:value-of select="rss/channel/image/url"/>
    </xsl:attribute>
	</img>
	</p>
	<xsl:element name="a">
    <xsl:attribute name="href">
        <xsl:value-of select="rss/channel/image/link"/>
	</xsl:attribute>
		<xsl:value-of select="rss/channel/image/link"/>
	</xsl:element>
	
	<div id="one">
		<xsl:for-each select="/rss/channel/item">
			<font face="Arial" size="4px" ><p><xsl:value-of select="title"/></p></font>
			<xsl:element name="a">
				<xsl:attribute name="href">
					<xsl:value-of select="link"/>
				</xsl:attribute>
					<xsl:value-of select="link"/>
			</xsl:element>
			<table border="2">
				<tr>
				<th colspan="2">
				<xsl:element name="a">
				<xsl:attribute name="href">
					<xsl:value-of select="link"/>
				</xsl:attribute>
					<xsl:value-of select="comments"/>
				</xsl:element>
				
					<tr>
						<th>Publication Date</th>
						<th>Creator</th>
					</tr>
					<tr>
						<td width="50%"><xsl:value-of select="pubDate"/></td>
						<td width="50%"><xsl:value-of select="dc:creator"/></td>
					</tr>
				</th>
				</tr>
			</table>
			
			<xsl:for-each select="category">
			 <div id="two"><xsl:value-of select="text()" disable-output-escaping="yes"/><xsl:text>, </xsl:text></div>
			<!-- <xsl:apply-templates select="rss/channel/item/category"/> -->
			</xsl:for-each>
			
			<div><xsl:element name="a">
				<xsl:attribute name="href">
					<xsl:value-of select="link"/>
				</xsl:attribute>
					<xsl:value-of select="guid"/>
				</xsl:element>
			</div>
			<p><xsl:value-of select="description" disable-output-escaping="yes"/></p>
			<table border="1">
			<tr>
			<th><xsl:element name="a">
				<xsl:attribute name="href">
					<xsl:value-of select="link"/>
				</xsl:attribute>
					<xsl:value-of select="wfw:commentRss"/>
				</xsl:element></th>
			</tr>
			<tr>
			<td>comments</td>
			<td><xsl:value-of select="slash:comments"/></td>
			</tr>
			</table>
			
			
		</xsl:for-each>
	</div>
	
	
</body>
</html>
</xsl:template>
</xsl:stylesheet>
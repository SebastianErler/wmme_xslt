<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Photon Images</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
      	<th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Author</th>
        <th>Width</th>
        <th>Height</th>
      </tr>
      <xsl:for-each select="html/body/ul[@id='photoList']/li">
        <tr>
          <td><xsl:value-of select="@id"/></td>
          <td><xsl:value-of select="h2"/></td>
          <td><xsl:value-of select="p[@class='description']"/></td>
          <td><xsl:value-of select="h3[@class='author']"/></td>
          <td><xsl:value-of select="dl/dd[1]"/></td>
          <td><xsl:value-of select="dl/dd[2]"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
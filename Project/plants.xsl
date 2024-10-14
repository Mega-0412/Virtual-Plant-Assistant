<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <!-- Template to match the root element -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Plant Care Information</title>
                <style>
                    table {
                        border-collapse: collapse;
                        width: 100%;
                    }
                    th, td {
                        border: 1px solid #dddddd;
                        text-align: left;
                        padding: 8px;
                    }
                    th {
                        background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h2>Plant Care Information</h2>
                <table>
                    <tr>
                        <th>Plant ID</th>
                        <th>Plant Name</th>
                        <th>Water Frequency</th>
                        <th>Water Amount</th>
                        <th>Light Type</th>
                        <th>Light Duration</th>
                        <th>Fertilizer Type</th>
                        <th>Fertilizer Frequency</th>
                        <th>Ideal Temperature</th>
                    </tr>
                    <!-- Loop through each Plant element -->
                    <xsl:for-each select="Plants/Plant">
                        <tr>
                            <td><xsl:value-of select="PlantID"/></td>
                            <td><xsl:value-of select="PlantName"/></td>
                            <td><xsl:value-of select="WaterRequirements/Frequency"/></td>
                            <td><xsl:value-of select="WaterRequirements/Amount"/></td>
                            <td><xsl:value-of select="LightRequirements/Type"/></td>
                            <td><xsl:value-of select="LightRequirements/Duration"/></td>
                            <td><xsl:value-of select="Fertilizer/Type"/></td>
                            <td><xsl:value-of select="Fertilizer/Frequency"/></td>
                            <td><xsl:value-of select="IdealTemperature"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>


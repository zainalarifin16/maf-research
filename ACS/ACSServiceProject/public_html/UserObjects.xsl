<?xml version="1.0" encoding="UTF-8"?>
 <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
version="1.0" >
     <xsl:template match="userObjects">
         <userObjects>
           <xsl:for-each select="userObject">
               <userObject>
                   <username><xsl:value-of select="username"/></username>
               </userObject>
           </xsl:for-each>
         </userObjects>

     </xsl:template>
 </xsl:stylesheet>

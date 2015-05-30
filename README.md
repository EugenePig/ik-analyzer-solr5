# Introduction #
The original creator of IKAnalyzer is [Liang-Yi Lin ](linliangyi2007@gmail.com) . The project home is [http://code.google.com/p/ik-analyzer/](http://code.google.com/p/ik-analyzer/) .

# Feature #
 - based on IK Analyer 2012-FF Hotfix 1 
 - added support for Lucene 5.1.0 API

#Installation #

 - JDK8 

>  mvn clean install

 - JDK7

> mvn clean -Djavac.src.version=1.7 -Djavac.target.version=1.7 install

copy ik-analyzer-solr5-5.x.jar to server/solr-webapp/webapp/WEB-INF/lib

# Configuration #
    <fieldType name="text_ik" class="solr.TextField">   
      <analyzer type="index">
        <tokenizer class="org.wltea.analyzer.lucene.IKTokenizerFactory" useSmart="false" />
      </analyzer>
      <analyzer type="query">
        <tokenizer class="org.wltea.analyzer.lucene.IKTokenizerFactory" useSmart="true" />
      </analyzer>
    </fieldType>

or
    
    <fieldType name="text_ik" class="solr.TextField">   
      <analyzer type="index" useSmart="false" class="org.wltea.analyzer.lucene.IKAnalyzer"/>   
      <analyzer type="query" useSmart="true" class="org.wltea.analyzer.lucene.IKAnalyzer"/>   
    </fieldType>
    
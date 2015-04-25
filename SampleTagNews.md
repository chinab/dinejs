In this sample we will play with different services offered in the web. We use dine to read an RSS newsfeed and after that we will use http://www.tagthe.net to get a list of tags for each news entry. Those tags are automatically generated and describe the content of the tagged website.

This could for example be used to find news posts from different websites that describe the same event.

# Code #

_readFeed.js_

```
createStep({
	getUrl: function( ctx ) {
		return "http://www.tagesschau.de/newsticker.rdf";
	},
	
	run: function( ctx ) {		

		// create E4X object from the XML response
		var xml = new XML( ctx.getResponse() );
		
		// find all articles in the RSS	
		for each( var article in xml..item ) {
			
			// trigger the tagging step
			ctx.addStep( "/tagArticle", createMap({ url: article.link, title: article.title }) );
		}
	}
	
});
```

_tagArticle.js_

```
createStep({
	getUrl: function( ctx ) {
		// give the article's url to tagthe.net 
		return "http://tagthe.net/api/?url="+ctx.getParam("url");
	},
	run: function( ctx ) {		
		
		// create an E4X object from the response
		var xml = new XML( ctx.getResponse() );
		
		// our own XML output
		var output = <article title={ctx.getParam("title")} url={ctx.getParam("url")}/>;
		
		// find all tags from tagthe.net's XML response
		for each ( var tags in xml..dim ) {			
			for each ( var tag in tags.item ) {
			 			
			 	// add the tag to our output		
				output.appendChild(
							<tag type={tags.@type}>{tag.text()}</tag>
						);
						
			}			
		}
		
		print( output.toXMLString() );
	}
});
```


# Sample Output #

_there are still some encoding errors in the output, there's already a bug report for this, hope it will be fixed soon_

```
<article title="Merkels Fazit zum EU-Lateinamerika-Gipfel" url="http://www.tagesschau.de/ausland/lateinamerika8.html">
  <tag type="topic">Fortschritt</tag>
  <tag type="topic">Merkel</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Land</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">J. Wagner</tag>
  <tag type="person">Hugo Ch?vez</tag>
  <tag type="title">Merkels Fazit zum EU-Lateinamerika-Gipfel | tagesschau.de</tag>
  <tag type="location">Lateinamerikas</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Peru</tag>
  <tag type="location">Bonn</tag>
  <tag type="location">Mexiko</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Argentiniens</tag>
  <tag type="location">Europa</tag>
  <tag type="location">Wien</tag>
  <tag type="location">Lateinamerika</tag>
  <tag type="location">Kolumbien</tag>
  <tag type="location">Bolivien</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Ecuador</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
<article title="Nach dem Beben in China: Deutscher Tourist gerettet" url="http://www.tagesschau.de/ausland/erdbeben96.html">
  <tag type="topic">Mensch</tag>
  <tag type="topic">Tourist</tag>
  <tag type="topic">Angabe</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Beben</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Erdbeben</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Nicole B?lhoff</tag>
  <tag type="title">Nach dem Beben in China: Deutscher Tourist gerettet | tagesschau.de</tag>
  <tag type="location">China</tag>
  <tag type="location">Peking</tag>
  <tag type="location">Epizentrum</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">US</tag>
  <tag type="location">Zentralkrankenhaus</tag>
  <tag type="language">german</tag>
</article>
<article title="Birmanische Junta l?sst UN-Koordinator Holmes ins Land" url="http://www.tagesschau.de/ausland/birma700.html">
  <tag type="topic">UN-Koordinator</tag>
  <tag type="topic">Mensch</tag>
  <tag type="topic">Angabe</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Land</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Hilfsgut</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Sandra Ratzow</tag>
  <tag type="person">John Holmes</tag>
  <tag type="title">Birmanische Junta l?sst UN-Koordinator Holmes ins Land | tagesschau.de</tag>
  <tag type="location">Birma</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Thailand</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
<article title="Steuerstreit in der Union geht weiter" url="http://www.tagesschau.de/inland/steuerstreit6.html">
  <tag type="topic">Forderung</tag>
  <tag type="topic">Steuerstreit</tag>
  <tag type="topic">Inland</tag>
  <tag type="topic">Union</tag>
  <tag type="topic">Steuersenkung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Angela Merkel</tag>
  <tag type="person">Erwin Huber</tag>
  <tag type="person">Peter M?ller</tag>
  <tag type="person">Wolfgang Bosbach</tag>
  <tag type="person">Thema  Neue</tag>
  <tag type="person">Fritz Kuhn</tag>
  <tag type="title">Steuerstreit in der Union geht weiter | tagesschau.de</tag>
  <tag type="location">Baden-W?rttemberg</tag>
  <tag type="location">Saarlands</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Saarland</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Bosbach</tag>
  <tag type="location">W?rttemberg</tag>
  <tag type="language">german</tag>
</article>
<article title="Leuk?mie: Kampagne f?r Knochenmarkspenden" url="http://www.tagesschau.de/inland/knochenmark4.html">
  <tag type="topic">Kampagne</tag>
  <tag type="topic">Inland</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Knochenmarkspende</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Leuk?mie</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Olympia-Siegerinnen</tag>
  <tag type="title">Leuk?mie: Kampagne f?r Knochenmarkspenden | tagesschau.de</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="Saudi-Arabien verspricht Bush h?here ?l-F?rdermenge" url="http://www.tagesschau.de/ausland/bushinsaudiarabien2.html">
  <tag type="topic">US-Pr?sident</tag>
  <tag type="topic">Beziehung</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Bush</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Bildunterschrift</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Ibrahim Mugaiteeb</tag>
  <tag type="person">Von Esther Saoub</tag>
  <tag type="title">Saudi-Arabien verspricht Bush h?here ?l-F?rdermenge | tagesschau.de</tag>
  <tag type="location">Westen</tag>
  <tag type="location">Kuwaits</tag>
  <tag type="location">US-Panzer</tag>
  <tag type="location">Amerika</tag>
  <tag type="location">Kairo</tag>
  <tag type="location">Krankenh?user</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Saudi-Arabien</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Irak</tag>
  <tag type="location">US</tag>
  <tag type="location">USA</tag>
  <tag type="language">german</tag>
</article>
<article title="17. Mai ist nationaler Feiertag der Esel in Kenia" url="http://www.tagesschau.de/ausland/esel6.html">
  <tag type="topic">Mai</tag>
  <tag type="topic">Esel</tag>
  <tag type="topic">Karren</tag>
  <tag type="topic">Tag</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Tier</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Bauer</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Pascal Kaumbutho</tag>
  <tag type="person">Von Wim Dohrenbusch</tag>
  <tag type="title">17. Mai ist nationaler Feiertag der Esel in Kenia | tagesschau.de</tag>
  <tag type="location">Eselsklinik</tag>
  <tag type="location">Kenia</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Marktplatz</tag>
  <tag type="location">US</tag>
  <tag type="location">Nairobi</tag>
  <tag type="language">german</tag>
</article>
<article title="Einigung bei UN-Konferenz zu Gentechnik-Sch?den" url="http://www.tagesschau.de/inland/gentechnik20.html">
  <tag type="topic">Ergebnis</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Land</tag>
  <tag type="topic">Schaden</tag>
  <tag type="topic">UN-Konferenz</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Einigung</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">M. Keienburg</tag>
  <tag type="person">Ursula Heinen</tag>
  <tag type="person">Matthias Keienburg</tag>
  <tag type="person">Wolfgang Koehler</tag>
  <tag type="title">Einigung bei UN-Konferenz zu Gentechnik-Sch?den | tagesschau.de</tag>
  <tag type="location">Japan</tag>
  <tag type="location">Bonn</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Keienburg</tag>
  <tag type="language">german</tag>
</article>
<article title="Textilindustrie vermisst Konfektionsgr??en neu" url="http://www.tagesschau.de/wirtschaft/konfektionsgroessen2.html">
  <tag type="topic">Textilindustrie</tag>
  <tag type="topic">Liste</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Konfektionsgr??e</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Wirtschaft</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Von Ute Kindler</tag>
  <tag type="person">Ute Kindler</tag>
  <tag type="title">Textilindustrie vermisst Konfektionsgr??en neu | tagesschau.de</tag>
  <tag type="location">Bochum</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="T?dliche Messerattacke auf Schwester gestanden" url="http://www1.ndr.de/nachrichten/hamburg/jugendliche26.html">
  <tag type="topic">Seitenanfang</tag>
  <tag type="topic">Schwester</tag>
  <tag type="topic">M?dchen</tag>
  <tag type="topic">Fall</tag>
  <tag type="topic">Tat</tag>
  <tag type="topic">Fernsehen</tag>
  <tag type="topic">Bruder</tag>
  <tag type="topic">J?hrige</tag>
  <tag type="topic">Familie</tag>
  <tag type="topic">NDR</tag>
  <tag type="content-type">text/html</tag>
  <tag type="author">NDR</tag>
  <tag type="title">NDR Online - Nachrichten - Hamburg- Messerattacke auf 16-J?hrige: Bruder gest?ndig</tag>
  <tag type="location">Mecklenburg-Vorpommern</tag>
  <tag type="location">London</tag>
  <tag type="location">Schleswig-Holstein</tag>
  <tag type="location">Hamburg</tag>
  <tag type="location">Afghanistan</tag>
  <tag type="location">Niedersachsen</tag>
  <tag type="location">Polizeihochhauses</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Hamburger</tag>
  <tag type="location">Berliner</tag>
  <tag type="language">german</tag>
</article>
<article title="Experten kritisieren Modelle zur Mitarbeiterbeteiligung" url="http://www.tagesschau.de/wirtschaft/mitarbeiterbeteiligung14.html">
  <tag type="topic">Unternehmen</tag>
  <tag type="topic">Liste</tag>
  <tag type="topic">Experte</tag>
  <tag type="topic">Beirat</tag>
  <tag type="topic">Modell</tag>
  <tag type="topic">Mitarbeiterbeteiligung</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Wirtschaft</tag>
  <tag type="topic">Beteiligung</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Claudia Buch</tag>
  <tag type="title">Experten kritisieren Modelle zur Mitarbeiterbeteiligung  | tagesschau.de</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="Empfang des Dalai Lama sorgt weiter f?r Spannungen" url="http://www.tagesschau.de/inland/dalailama122.html">
  <tag type="topic">Besuch</tag>
  <tag type="topic">Jahrhundert</tag>
  <tag type="topic">Zeul</tag>
  <tag type="topic">Treffen</tag>
  <tag type="topic">Inland</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Horst K?hler</tag>
  <tag type="person">Angela Merkel</tag>
  <tag type="person">Heidemarie Wieczorek-</tag>
  <tag type="person">Dalai-Lama</tag>
  <tag type="person">Frank-Walter Steinmeier</tag>
  <tag type="title">Empfang des Dalai Lama sorgt weiter f?r Spannungen | tagesschau.de</tag>
  <tag type="location">China</tag>
  <tag type="location">Peking</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Veranstaltungshalle</tag>
  <tag type="location">Bochum</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Brandenburger</tag>
  <tag type="language">german</tag>
</article>
<article title="Mindestens zehn Tote bei Anschlag in Colombo" url="http://www.tagesschau.de/ausland/colombo8.html">
  <tag type="topic">Colombo</tag>
  <tag type="topic">Mensch</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Anschlag</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Sandra Petersmann</tag>
  <tag type="person">S. Petersmann</tag>
  <tag type="person">Sri Lankas</tag>
  <tag type="title">Mindestens zehn Tote bei Anschlag in Colombo | tagesschau.de</tag>
  <tag type="location">Arabien</tag>
  <tag type="location">Lateinamerika</tag>
  <tag type="location">China</tag>
  <tag type="location">Sri Lanka</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Neu Delhi</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
<article title="Schlechte Umfragen: McCain schmei?t Irak-Strategie um" url="http://www.tagesschau.de/ausland/mccain62.html">
  <tag type="topic">McCain</tag>
  <tag type="topic">Haus</tag>
  <tag type="topic">John</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Republikaner</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Von Jens Borchers</tag>
  <tag type="title">Schlechte Umfragen: McCain schmei?t Irak-Strategie um | tagesschau.de</tag>
  <tag type="location">Amerika</tag>
  <tag type="location">US-W?hler</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Repr?sentantenhaus</tag>
  <tag type="location">Irak</tag>
  <tag type="location">Bagdad</tag>
  <tag type="location">Washington</tag>
  <tag type="location">US</tag>
  <tag type="location">Iran</tag>
  <tag type="language">german</tag>
</article>
<article title="Neuer Transnet-Chef Krau? &quot;stinksauer&quot; auf Hansen" url="http://www.tagesschau.de/wirtschaft/hansen22.html">
  <tag type="topic">Liste</tag>
  <tag type="topic">Bahn</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Vorsitzende</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Wirtschaft</tag>
  <tag type="topic">Chef</tag>
  <tag type="topic">Mehdorn</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Lothar Krau?</tag>
  <tag type="person">Norbert Hansen</tag>
  <tag type="title">Neuer Transnet-Chef Krau? "stinksauer" auf Hansen | tagesschau.de</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="Letzte Schicht im Nokia-Werk Bochum" url="http://www.wdr.de/themen/wirtschaft/wirtschaftsbranche/nokia/080516.jhtml">
  <tag type="topic">Hoffnung</tag>
  <tag type="topic">Nokia</tag>
  <tag type="topic">Firma</tag>
  <tag type="topic">Trauer</tag>
  <tag type="topic">Werk</tag>
  <tag type="topic">Solidarit?tszelt</tag>
  <tag type="topic">Tag</tag>
  <tag type="topic">Standort</tag>
  <tag type="topic">Anfang</tag>
  <tag type="topic">Mitarbeiter</tag>
  <tag type="content-type">text/html</tag>
  <tag type="author">Herrmanny (jul)</tag>
  <tag type="person">Den Kontakt</tag>
  <tag type="person">Anna Knobloch</tag>
  <tag type="person">Thema  

  

     
  
  Schichtende</tag>
  <tag type="person">Martina Blum</tag>
  <tag type="person">Raimund Pozimski</tag>
  <tag type="title">Nokias letzter Tag - Wirtschaft - 
WDR.de</tag>
  <tag type="location">Arbeitsplatz</tag>
  <tag type="location">Asien</tag>
  <tag type="location">H?he</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Parkplatz</tag>
  <tag type="location">Bochums</tag>
  <tag type="location">Bochum</tag>
  <tag type="location">Rum?nien</tag>
  <tag type="location">Essen</tag>
  <tag type="location">Osteuropa</tag>
  <tag type="location">Bochumer</tag>
  <tag type="language">german</tag>
  <tag type="size">0</tag>
</article>
<article title="L?w pr?sentiert den EM-Kader" url="http://sport.ard.de/euro2008/news200805/16/kader_deutschland.jsp">
  <tag type="topic">Nachricht</tag>
  <tag type="topic">Deutsche</tag>
  <tag type="topic">Team</tag>
  <tag type="topic">Kader</tag>
  <tag type="topic">Spiel</tag>
  <tag type="topic">Spieler</tag>
  <tag type="topic">Aufgebot</tag>
  <tag type="topic">Marin</tag>
  <tag type="topic">EURO</tag>
  <tag type="topic">Adler</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Joachim L?w</tag>
  <tag type="person">Oliver Neuville</tag>
  <tag type="person">Patrick Helmes</tag>
  <tag type="person">Robert Enke</tag>
  <tag type="person">Timo Hildebrand</tag>
  <tag type="person">Thema  
            
              
                  Der</tag>
  <tag type="person">Tim Borowski</tag>
  <tag type="title">L?w nominiert Adler und Marin - 
    
      
        
        
      Deutsches Team - Nachrichten - EURO 2008</tag>
  <tag type="location">K?ln</tag>
  <tag type="location">Mallorca</tag>
  <tag type="location">Hannovers</tag>
  <tag type="location">M?nchengladbach</tag>
  <tag type="location">Polen</tag>
  <tag type="location">Zugspitze</tag>
  <tag type="language">german</tag>
</article>
<article title="Schlusslicht: 100 Jahre Handy" url="http://www.tagesschau.de/schlusslicht/handy16.html">
  <tag type="topic">September</tag>
  <tag type="topic">M?rz</tag>
  <tag type="topic">Mai</tag>
  <tag type="topic">Oktober</tag>
  <tag type="topic">November</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">April</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Handy  
  Kannst</tag>
  <tag type="person">Nathan Stubblefield</tag>
  <tag type="title">Schlusslicht: 100 Jahre Handy | tagesschau.de</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
08:43:56,315 INFO  [MultithreadedStepExecutor] done
e178076213:~/Entwicklung/workspace/dinejs/resources/dist alombra$ clear

e178076213:~/Entwicklung/workspace/dinejs/resources/dist alombra$ java -jar dine-0.3-beta-cli.jar 50 ../../samples/tagRss/ . /readFeed
08:46:34,149 INFO  [RhinoBuilder] generating step [/tagArticle]
08:46:34,303 INFO  [RhinoBuilder] generating step [/readFeed]
<article title="Merkels Fazit zum EU-Lateinamerika-Gipfel" url="http://www.tagesschau.de/ausland/lateinamerika8.html">
  <tag type="topic">Fortschritt</tag>
  <tag type="topic">Merkel</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Land</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">J. Wagner</tag>
  <tag type="person">Hugo Ch?vez</tag>
  <tag type="title">Merkels Fazit zum EU-Lateinamerika-Gipfel | tagesschau.de</tag>
  <tag type="location">Lateinamerikas</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Peru</tag>
  <tag type="location">Bonn</tag>
  <tag type="location">Mexiko</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Argentiniens</tag>
  <tag type="location">Europa</tag>
  <tag type="location">Wien</tag>
  <tag type="location">Lateinamerika</tag>
  <tag type="location">Kolumbien</tag>
  <tag type="location">Bolivien</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Ecuador</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
<article title="Nach dem Beben in China: Deutscher Tourist gerettet" url="http://www.tagesschau.de/ausland/erdbeben96.html">
  <tag type="topic">Mensch</tag>
  <tag type="topic">Tourist</tag>
  <tag type="topic">Angabe</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Beben</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Erdbeben</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Nicole B?lhoff</tag>
  <tag type="title">Nach dem Beben in China: Deutscher Tourist gerettet | tagesschau.de</tag>
  <tag type="location">China</tag>
  <tag type="location">Peking</tag>
  <tag type="location">Epizentrum</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">US</tag>
  <tag type="location">Zentralkrankenhaus</tag>
  <tag type="language">german</tag>
</article>
<article title="Birmanische Junta l?sst UN-Koordinator Holmes ins Land" url="http://www.tagesschau.de/ausland/birma700.html">
  <tag type="topic">UN-Koordinator</tag>
  <tag type="topic">Mensch</tag>
  <tag type="topic">Angabe</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Land</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Hilfsgut</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Sandra Ratzow</tag>
  <tag type="person">John Holmes</tag>
  <tag type="title">Birmanische Junta l?sst UN-Koordinator Holmes ins Land | tagesschau.de</tag>
  <tag type="location">Birma</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Thailand</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
<article title="Steuerstreit in der Union geht weiter" url="http://www.tagesschau.de/inland/steuerstreit6.html">
  <tag type="topic">Forderung</tag>
  <tag type="topic">Steuerstreit</tag>
  <tag type="topic">Inland</tag>
  <tag type="topic">Union</tag>
  <tag type="topic">Steuersenkung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Angela Merkel</tag>
  <tag type="person">Erwin Huber</tag>
  <tag type="person">Peter M?ller</tag>
  <tag type="person">Wolfgang Bosbach</tag>
  <tag type="person">Thema  Neue</tag>
  <tag type="person">Fritz Kuhn</tag>
  <tag type="title">Steuerstreit in der Union geht weiter | tagesschau.de</tag>
  <tag type="location">Baden-W?rttemberg</tag>
  <tag type="location">Saarlands</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Saarland</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Bosbach</tag>
  <tag type="location">W?rttemberg</tag>
  <tag type="language">german</tag>
</article>
<article title="Leuk?mie: Kampagne f?r Knochenmarkspenden" url="http://www.tagesschau.de/inland/knochenmark4.html">
  <tag type="topic">Kampagne</tag>
  <tag type="topic">Inland</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Knochenmarkspende</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Leuk?mie</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Olympia-Siegerinnen</tag>
  <tag type="title">Leuk?mie: Kampagne f?r Knochenmarkspenden | tagesschau.de</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="Saudi-Arabien verspricht Bush h?here ?l-F?rdermenge" url="http://www.tagesschau.de/ausland/bushinsaudiarabien2.html">
  <tag type="topic">US-Pr?sident</tag>
  <tag type="topic">Beziehung</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Bush</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Bildunterschrift</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Ibrahim Mugaiteeb</tag>
  <tag type="person">Von Esther Saoub</tag>
  <tag type="title">Saudi-Arabien verspricht Bush h?here ?l-F?rdermenge | tagesschau.de</tag>
  <tag type="location">Westen</tag>
  <tag type="location">Kuwaits</tag>
  <tag type="location">US-Panzer</tag>
  <tag type="location">Amerika</tag>
  <tag type="location">Kairo</tag>
  <tag type="location">Krankenh?user</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Saudi-Arabien</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Irak</tag>
  <tag type="location">US</tag>
  <tag type="location">USA</tag>
  <tag type="language">german</tag>
</article>
<article title="17. Mai ist nationaler Feiertag der Esel in Kenia" url="http://www.tagesschau.de/ausland/esel6.html">
  <tag type="topic">Mai</tag>
  <tag type="topic">Esel</tag>
  <tag type="topic">Karren</tag>
  <tag type="topic">Tag</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Tier</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Bauer</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Pascal Kaumbutho</tag>
  <tag type="person">Von Wim Dohrenbusch</tag>
  <tag type="title">17. Mai ist nationaler Feiertag der Esel in Kenia | tagesschau.de</tag>
  <tag type="location">Eselsklinik</tag>
  <tag type="location">Kenia</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Marktplatz</tag>
  <tag type="location">US</tag>
  <tag type="location">Nairobi</tag>
  <tag type="language">german</tag>
</article>
<article title="Einigung bei UN-Konferenz zu Gentechnik-Sch?den" url="http://www.tagesschau.de/inland/gentechnik20.html">
  <tag type="topic">Ergebnis</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Land</tag>
  <tag type="topic">Schaden</tag>
  <tag type="topic">UN-Konferenz</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Einigung</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">M. Keienburg</tag>
  <tag type="person">Ursula Heinen</tag>
  <tag type="person">Matthias Keienburg</tag>
  <tag type="person">Wolfgang Koehler</tag>
  <tag type="title">Einigung bei UN-Konferenz zu Gentechnik-Sch?den | tagesschau.de</tag>
  <tag type="location">Japan</tag>
  <tag type="location">Bonn</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Keienburg</tag>
  <tag type="language">german</tag>
</article>
<article title="Textilindustrie vermisst Konfektionsgr??en neu" url="http://www.tagesschau.de/wirtschaft/konfektionsgroessen2.html">
  <tag type="topic">Textilindustrie</tag>
  <tag type="topic">Liste</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Konfektionsgr??e</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Wirtschaft</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Von Ute Kindler</tag>
  <tag type="person">Ute Kindler</tag>
  <tag type="title">Textilindustrie vermisst Konfektionsgr??en neu | tagesschau.de</tag>
  <tag type="location">Bochum</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="T?dliche Messerattacke auf Schwester gestanden" url="http://www1.ndr.de/nachrichten/hamburg/jugendliche26.html">
  <tag type="topic">Seitenanfang</tag>
  <tag type="topic">Schwester</tag>
  <tag type="topic">M?dchen</tag>
  <tag type="topic">Fall</tag>
  <tag type="topic">Tat</tag>
  <tag type="topic">Fernsehen</tag>
  <tag type="topic">Bruder</tag>
  <tag type="topic">J?hrige</tag>
  <tag type="topic">Familie</tag>
  <tag type="topic">NDR</tag>
  <tag type="content-type">text/html</tag>
  <tag type="author">NDR</tag>
  <tag type="title">NDR Online - Nachrichten - Hamburg- Messerattacke auf 16-J?hrige: Bruder gest?ndig</tag>
  <tag type="location">Mecklenburg-Vorpommern</tag>
  <tag type="location">London</tag>
  <tag type="location">Schleswig-Holstein</tag>
  <tag type="location">Hamburg</tag>
  <tag type="location">Afghanistan</tag>
  <tag type="location">Niedersachsen</tag>
  <tag type="location">Polizeihochhauses</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Hamburger</tag>
  <tag type="location">Berliner</tag>
  <tag type="language">german</tag>
</article>
<article title="Experten kritisieren Modelle zur Mitarbeiterbeteiligung" url="http://www.tagesschau.de/wirtschaft/mitarbeiterbeteiligung14.html">
  <tag type="topic">Unternehmen</tag>
  <tag type="topic">Liste</tag>
  <tag type="topic">Experte</tag>
  <tag type="topic">Beirat</tag>
  <tag type="topic">Modell</tag>
  <tag type="topic">Mitarbeiterbeteiligung</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Wirtschaft</tag>
  <tag type="topic">Beteiligung</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Claudia Buch</tag>
  <tag type="title">Experten kritisieren Modelle zur Mitarbeiterbeteiligung  | tagesschau.de</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="Empfang des Dalai Lama sorgt weiter f?r Spannungen" url="http://www.tagesschau.de/inland/dalailama122.html">
  <tag type="topic">Besuch</tag>
  <tag type="topic">Jahrhundert</tag>
  <tag type="topic">Zeul</tag>
  <tag type="topic">Treffen</tag>
  <tag type="topic">Inland</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Horst K?hler</tag>
  <tag type="person">Angela Merkel</tag>
  <tag type="person">Heidemarie Wieczorek-</tag>
  <tag type="person">Dalai-Lama</tag>
  <tag type="person">Frank-Walter Steinmeier</tag>
  <tag type="title">Empfang des Dalai Lama sorgt weiter f?r Spannungen | tagesschau.de</tag>
  <tag type="location">China</tag>
  <tag type="location">Peking</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Veranstaltungshalle</tag>
  <tag type="location">Bochum</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Brandenburger</tag>
  <tag type="language">german</tag>
</article>
<article title="Mindestens zehn Tote bei Anschlag in Colombo" url="http://www.tagesschau.de/ausland/colombo8.html">
  <tag type="topic">Colombo</tag>
  <tag type="topic">Mensch</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Anschlag</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">Uhr</tag>
  <tag type="topic">ARD</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Sandra Petersmann</tag>
  <tag type="person">S. Petersmann</tag>
  <tag type="person">Sri Lankas</tag>
  <tag type="title">Mindestens zehn Tote bei Anschlag in Colombo | tagesschau.de</tag>
  <tag type="location">Arabien</tag>
  <tag type="location">Lateinamerika</tag>
  <tag type="location">China</tag>
  <tag type="location">Sri Lanka</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Neu Delhi</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
<article title="Schlechte Umfragen: McCain schmei?t Irak-Strategie um" url="http://www.tagesschau.de/ausland/mccain62.html">
  <tag type="topic">McCain</tag>
  <tag type="topic">Haus</tag>
  <tag type="topic">John</tag>
  <tag type="topic">Sendung</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Ausland</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Republikaner</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Von Jens Borchers</tag>
  <tag type="title">Schlechte Umfragen: McCain schmei?t Irak-Strategie um | tagesschau.de</tag>
  <tag type="location">Amerika</tag>
  <tag type="location">US-W?hler</tag>
  <tag type="location">Tibet</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">Repr?sentantenhaus</tag>
  <tag type="location">Irak</tag>
  <tag type="location">Bagdad</tag>
  <tag type="location">Washington</tag>
  <tag type="location">US</tag>
  <tag type="location">Iran</tag>
  <tag type="language">german</tag>
</article>
<article title="Neuer Transnet-Chef Krau? &quot;stinksauer&quot; auf Hansen" url="http://www.tagesschau.de/wirtschaft/hansen22.html">
  <tag type="topic">Liste</tag>
  <tag type="topic">Bahn</tag>
  <tag type="topic">Hinweis</tag>
  <tag type="topic">Vorsitzende</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">Wirtschaft</tag>
  <tag type="topic">Chef</tag>
  <tag type="topic">Mehdorn</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Lothar Krau?</tag>
  <tag type="person">Norbert Hansen</tag>
  <tag type="title">Neuer Transnet-Chef Krau? "stinksauer" auf Hansen | tagesschau.de</tag>
  <tag type="location">Berlin</tag>
  <tag type="language">german</tag>
</article>
<article title="Letzte Schicht im Nokia-Werk Bochum" url="http://www.wdr.de/themen/wirtschaft/wirtschaftsbranche/nokia/080516.jhtml">
  <tag type="topic">Hoffnung</tag>
  <tag type="topic">Nokia</tag>
  <tag type="topic">Firma</tag>
  <tag type="topic">Trauer</tag>
  <tag type="topic">Werk</tag>
  <tag type="topic">Solidarit?tszelt</tag>
  <tag type="topic">Tag</tag>
  <tag type="topic">Standort</tag>
  <tag type="topic">Anfang</tag>
  <tag type="topic">Mitarbeiter</tag>
  <tag type="content-type">text/html</tag>
  <tag type="author">Herrmanny (jul)</tag>
  <tag type="person">Den Kontakt</tag>
  <tag type="person">Anna Knobloch</tag>
  <tag type="person">Thema  

  

     
  
  Schichtende</tag>
  <tag type="person">Martina Blum</tag>
  <tag type="person">Raimund Pozimski</tag>
  <tag type="title">Nokias letzter Tag - Wirtschaft - 
WDR.de</tag>
  <tag type="location">Arbeitsplatz</tag>
  <tag type="location">Asien</tag>
  <tag type="location">H?he</tag>
  <tag type="location">Deutschland</tag>
  <tag type="location">Parkplatz</tag>
  <tag type="location">Bochums</tag>
  <tag type="location">Bochum</tag>
  <tag type="location">Rum?nien</tag>
  <tag type="location">Essen</tag>
  <tag type="location">Osteuropa</tag>
  <tag type="location">Bochumer</tag>
  <tag type="language">german</tag>
  <tag type="size">0</tag>
</article>
<article title="L?w pr?sentiert den EM-Kader" url="http://sport.ard.de/euro2008/news200805/16/kader_deutschland.jsp">
  <tag type="topic">Nachricht</tag>
  <tag type="topic">Deutsche</tag>
  <tag type="topic">Team</tag>
  <tag type="topic">Kader</tag>
  <tag type="topic">Spiel</tag>
  <tag type="topic">Spieler</tag>
  <tag type="topic">Aufgebot</tag>
  <tag type="topic">Marin</tag>
  <tag type="topic">EURO</tag>
  <tag type="topic">Adler</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Joachim L?w</tag>
  <tag type="person">Oliver Neuville</tag>
  <tag type="person">Patrick Helmes</tag>
  <tag type="person">Robert Enke</tag>
  <tag type="person">Timo Hildebrand</tag>
  <tag type="person">Thema  
            
              
                  Der</tag>
  <tag type="person">Tim Borowski</tag>
  <tag type="title">L?w nominiert Adler und Marin - 
    
      
        
        
      Deutsches Team - Nachrichten - EURO 2008</tag>
  <tag type="location">K?ln</tag>
  <tag type="location">Mallorca</tag>
  <tag type="location">Hannovers</tag>
  <tag type="location">M?nchengladbach</tag>
  <tag type="location">Polen</tag>
  <tag type="location">Zugspitze</tag>
  <tag type="language">german</tag>
</article>
<article title="Schlusslicht: 100 Jahre Handy" url="http://www.tagesschau.de/schlusslicht/handy16.html">
  <tag type="topic">September</tag>
  <tag type="topic">M?rz</tag>
  <tag type="topic">Mai</tag>
  <tag type="topic">Oktober</tag>
  <tag type="topic">November</tag>
  <tag type="topic">Weitere</tag>
  <tag type="topic">Inhalt</tag>
  <tag type="topic">Tagesschau</tag>
  <tag type="topic">ARD</tag>
  <tag type="topic">April</tag>
  <tag type="content-type">text/html</tag>
  <tag type="person">Handy  
  Kannst</tag>
  <tag type="person">Nathan Stubblefield</tag>
  <tag type="title">Schlusslicht: 100 Jahre Handy | tagesschau.de</tag>
  <tag type="location">Berlin</tag>
  <tag type="location">US</tag>
  <tag type="language">german</tag>
</article>
```
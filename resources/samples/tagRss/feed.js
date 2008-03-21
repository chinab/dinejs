createStep({
	getUrl: function() {
		if ( typeof(this.params.feedUrl) == "undefined" )
			return "http://www.tagesschau.de/newsticker.rdf";
			
		return this.params.feedUrl;
	},
	run: function() {		
			
		//parse another feed
		if ( typeof(this.params.feedUrl) == "undefined") {
			addStep("tagRss/feed", { feedUrl: "http://www.spiegel.de/schlagzeilen/rss/0,5291,20,00.xml" } );
			addStep("tagRss/feed", { feedUrl: "http://www.n-tv.de/23.rss" } );	
			addStep("tagRss/feed", { feedUrl: "http://www.faz.net/s/Rub/Tpl~Epartner~SRss_.xml" } );
			addStep("tagRss/feed", { feedUrl: "http://www.jungewelt.de/aktuell/newsticker.rss" } );
			addStep("tagRss/feed", { feedUrl: "http://www.n24.de/2/nachrichten/index.rss" } );
		}	
			
		for each( var link in this.xmlObj..item..link ) {
			addStep("tagRss/tagIt", { url: String(link) } );
		}
	}
	
});
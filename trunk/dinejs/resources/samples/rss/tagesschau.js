createStep({
	getUrl: function() {
		return "http://www.tagesschau.de/newsticker.rdf";
	},
	run: function() {		
			
		for each( var title in this.xmlObj..item..title ) {
			titleLine = String(title);
			titleLine = titleLine.replace(/:/g, "");
			titleLine = titleLine.replace(/\?/g, "");
			titleLine = titleLine.replace(/\"/g, "");
			var titleWords = titleLine.split(" ");
			
			for ( var n=0 ; n<titleWords.length ; n++ )

				if ( titleWords[n].charAt(0).toUpperCase() == titleWords[n].charAt(0) && titleWords[n].length > 3 )
					addStep("rss/geo", { place: titleWords[n], title: String(title) } );
		}
	}
});
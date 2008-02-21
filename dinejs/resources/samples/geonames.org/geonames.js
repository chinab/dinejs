createStep({
	getUrl: function() {
		return "http://ws.geonames.org/searchJSON?q=Alexanderplatz,berlin&maxRows=10";
	},
	run: function() {		

		for ( var n=0 ; n<this.jsonObj.totalResultsCount ; n++ ) {
			print( "found "+this.jsonObj.geonames[n].name+" at "+this.jsonObj.geonames[n].lat + "/" + this.jsonObj.geonames[n].lng);
		}

	}
});
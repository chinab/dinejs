createStep({
	getUrl: function() {
		return "http://ws.geonames.org/searchJSON?name_equals="+escape(this.memory.place)+"&maxRows=1";
	},
	run: function() {		

		for ( var n=0 ; n<this.jsonObj.totalResultsCount ; n++ )
			if ( typeof( this.jsonObj.geonames[n] ) != "undefined" ) {
				print( "found "+this.jsonObj.geonames[n].name+" at "+this.jsonObj.geonames[n].lat + "/" + this.jsonObj.geonames[n].lng+" for "+this.memory.title+"["+this.memory.place+"]");
			}
	}
});
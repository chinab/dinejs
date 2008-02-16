createStep({
	getUrl: function() {
		return this.memory.url;
	},
	run: function() {		
			out.println( "Checking "+this.memory.url+" "+String(this.httpResponseCode) );
	}
});
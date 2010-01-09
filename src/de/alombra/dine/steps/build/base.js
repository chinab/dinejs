var Class = {
	create: function( parent, def ) {

    if ( arguments.length == 1 ) def = parent, parent = null;

		var func = function() {};

		if ( parent != null && typeof( parent == "function" ) )
			func.prototype = new parent();	

		if ( def )
			for ( var prop in def )
				func.prototype[prop] = def[prop];

		return func;
	}
};


var AbstractStep = Class.create({

	getMethod: function() {
		return "GET";
	},
	getPostParams: function() {
		return createMap({});
	}
});


function createMap( mapDef ) {

	var map = new Packages.java.util.HashMap();

		for ( var prop in mapDef )
			map.put( prop, String(mapDef[prop]) );

	return map;
};

function createStep( stepImpl ) {
	var CustomStep = Class.create( AbstractStep, stepImpl );
	
	creator.setStep( 
		new Packages.de.alombra.dine.steps.Step( new CustomStep() ) 
	);	
}

function print( str )  {
	out.println( str );
}
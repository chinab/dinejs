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

var BaseStep = Class.create({

	  xmlObj: 					null,
	  jsonObj:					null,
	  params: 					{},
	  httpResponseCode: null,
		
		memories: null,
		
		setXmlStr: function( xmlStr ) {
			this.xmlObj = new XML( xmlStr );
		},
		
		setJsonStr: function ( jsonStr ) {
			this.jsonObj = eval("("+jsonStr+")");
		},
		
		addParameter: function( key, value ) {
			this.params[key] = value;			
		},
		
		setHttpResponse: function( code ) {
			this.httpResponseCode = code;
		},
		
		setMemory: function( syncedMem ) {
			this.memories = syncedMem;
		},
		
		inMemory: function( key ) {
			return this.memories.exists( key );
		},
		
		addToMemory: function( key, value ) {
			return this.memories.add( key, value );
		} 
		
});

function createStep( stepImpl ) {
	var CustomStep = Class.create( BaseStep, stepImpl );
	
	creator.setStep( 
		new Packages.de.alombra.dine.steps.Step( new CustomStep() ) 
	);	
}

function addStep( stepName, stepParameters ) {

  var parameters = new Packages.de.alombra.dine.steps.impl.StepParametersImpl();
  
	for ( var param in stepParameters )
		parameters.setAttribute( param, stepParameters[param] );

	executionContext.addStep( stepName, parameters );
}

function print( str )  {
	out.println( str );
}

function createFile( fileName, content ) {
	Packages.de.alombra.dine.util.IOUtil.createFile( fileName, content );
}
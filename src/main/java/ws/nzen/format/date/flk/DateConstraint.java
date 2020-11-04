/* see ../../../../../LICENSE for release details */
package ws.nzen.format.date.flk;

import java.util.NavigableSet;

/**

*/
public class DateConstraint
{

	NavigableSet<Integer> specificValues;
	int incrementBy;
	int maximumValue;


	/**  */
	public DateConstraint(
			NavigableSet<Integer> chosenValues, int stepMagnitude, int endOfRange
	) {
		if ( chosenValues == null )
			throw new NullPointerException( "values must not be null" );
		if ( endOfRange < 1 )
			throw new IllegalArgumentException( "range must have at least one value" );
		specificValues = chosenValues;
		if ( stepMagnitude < 1 )
			stepMagnitude = 1;
		incrementBy = stepMagnitude;
	}


	public int closestValuePriorTo(
			int anchor
	) {
		if ( specificValues.isEmpty() )
			return anchor - incrementBy; // FIX but does this need to wrap around ?
		for ( int candidate = anchor - incrementBy; candidate > 0; candidate -= incrementBy )
		{
			if ( specificValues.contains( candidate ) )
				return candidate;
		}
		Integer priorSpecificValue = specificValues.lower( anchor );
		if ( priorSpecificValue == null )
			return anchor - incrementBy;

		throw new RuntimeException( "unimplemented" );
	}


}



















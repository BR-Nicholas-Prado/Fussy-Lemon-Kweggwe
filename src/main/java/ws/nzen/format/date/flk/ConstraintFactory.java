/* see ../../../../../LICENSE for release details */
package ws.nzen.format.date.flk;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.NavigableSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**

*/
public class ConstraintFactory
{

	private DayOfMonthRule daysOfMonth = new DayOfMonthRule();


	/**  */
	public ConstraintFactory()
	{
	}


	public ConstraintFactory with(
			ChronoField unit, Integer... values
	) {
		switch ( unit )
		{
			case DAY_OF_MONTH :
			{
				for ( Integer day : values )
					daysOfMonth.addDay( day );
				break;
			}
			default :
			{
				throw new IllegalArgumentException( "unsupported unit" );
			}
		}
		return this;
	}


	public DateSequence build()
	{
		Map<ChronoField, DateConstraint> rules = new TreeMap<>();
		if ( ! daysOfMonth.specificDays.isEmpty() || daysOfMonth.incrementBy > 0 )
		{
			DateConstraint daysMonthFinal = new DateConstraint(
					daysOfMonth.specificDays, daysOfMonth.incrementBy, daysOfMonth.maxOfRange );
			rules.put( ChronoField.DAY_OF_MONTH, daysMonthFinal );
		}
		return new DateSequence( rules );
	}


	private class DayOfMonthRule
	{
		NavigableSet<Integer> specificDays = new TreeSet<>();
		int incrementBy = 0;
		int maxOfRange = Month.OCTOBER.maxLength();

		void addDay( Integer dayInMonth )
		{
			if ( dayInMonth < 1 || dayInMonth > maxOfRange )
				throw new IllegalArgumentException( "day out of range" );
		}
	}

}



















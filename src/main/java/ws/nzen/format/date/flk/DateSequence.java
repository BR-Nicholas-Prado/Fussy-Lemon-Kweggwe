/* see ../../../../../LICENSE for release details */
package ws.nzen.format.date.flk;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Map;

/**

*/
public class DateSequence
{

	Map<ChronoField, DateConstraint> rules;


	/**  */
	public DateSequence(
			Map<ChronoField, DateConstraint> toAdopt
	) {
		if ( toAdopt == null )
			throw new NullPointerException( "rules must not be null" );
		rules = toAdopt;
	}


	public LocalDate priorInSequence(
			LocalDate anchor
	) {
		int yearToAdopt = 0;
		Month monthToAdopt = null;
		int dayOfMonthToAdopt = 0;
		if ( rules.containsKey( ChronoField.DAY_OF_MONTH ) )
		{
			int dayInMonthOfAnchor = anchor.getDayOfMonth();
			//if ( dayInMonthOfAnchor >  )
		}
		// ¶ first fallback
		if ( yearToAdopt == 0 )
			yearToAdopt = anchor.getYear();
		if ( monthToAdopt == null )
			monthToAdopt = anchor.getMonth();
		if ( dayOfMonthToAdopt == 0 )
			dayOfMonthToAdopt = anchor.getDayOfMonth() -1;
		// ¶ validate fallback
		if ( dayOfMonthToAdopt == 0 )
		{
			if ( monthToAdopt == Month.JANUARY )
			{
				yearToAdopt--;
				monthToAdopt = Month.DECEMBER;
			}
			else
			{
				monthToAdopt = monthToAdopt.minus( 1 );
			}
			dayOfMonthToAdopt = monthToAdopt.maxLength();
		}

		throw new RuntimeException( "unimplemented" );
	}

}



















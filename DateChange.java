
public class DateChange
{
    private int day;
    private int month;
    private int year;
    private int removeYear, removeMonth;
    private double earthT;
    private double youT;
    private double v;
    public DateChange()
    {
        day = 0;
        month = 0;
        year = 0;
    }

    public DateChange(int m, int d, int y)
    {
        day = d;
        month = m;
        year = y;
    }

    /**
     * Calculates the velocity required to travel t1 years into the future
     * given a travel time of t2 years
     * @param t1 time passing on earth
     * @param t2 time passing for you
     */
    public void travelNoSpeed(double t1, double t2)
    {
        setSpeed(Math.sqrt(1 - Math.pow(t2 / t1, 2)));
    }

    /**
     * Calculates the time that would pass on earth given your velocity and how
     * much time passes for you
     * @param v velocity you are going
     * @param t time passing for you
     */
    public void travelNoEarthTime(double v, double t)
    {
        setEarthTime(t / (Math.sqrt(1 - Math.pow(v, 2))));
    }

    /**
     * Calculates the time that would pass for you given your velocity and how
     * much time passes on earth
     * @param v velocity you are going
     * @param t time passing for someone on earth
     */
    public void travelNoYouTime(double v, double t)
    {
        setYouTime(t * (Math.sqrt(1 - Math.pow(v, 2))));
    }

    /**
     * Takes in the amount of time changing and changes the date
     * @param x time changing
     */
    public void changeDate(double x)
    {

        addYears((int) x);
        removeYear = (int) x;
        if (removeYear != x)
        {
            x -= removeYear;
            addMonths((int) (x / .083333333));
            removeMonth = (int) (x / .083333333);
            x = (x / .083333333);
            x -= removeMonth;
            addDays((int) (x / .03333333));

            if (getMonth() / 12 >= 1)
            {
                addYears(getMonth() / 12);
                addMonths(-12);
            }

            if (getYear() % 4 == 0 && getYear() % 100 != 0 && getYear() == 2
                && getDay() > 29)
            {
                addMonths(1);
                addDays(-29);
            }
            else if (getYear() % 4 == 0 && getYear() % 100 == 0
                     && getYear() % 400 == 0 && getMonth() == 2
                     && getDay() > 29)
            {
                addMonths(1);
                addDays(-29);
            }
            else if (getDay() > 30
                     && (getMonth() != 1 && getMonth() != 3 && getMonth() != 5
                         && getMonth() != 7 && getMonth() != 8
                         && getMonth() != 10 && getMonth() != 11))
            {
                addMonths(1);
                addDays(-30);
                if (getMonth() / 12 >= 1)
                {
                    addYears(getMonth() / 12);
                    addMonths(-12);
                }
            }
            else if (getDay() > 31
                     && (getMonth() == 1 || getMonth() == 3 || getMonth() == 5
                         || getMonth() == 7 || getMonth() == 8
                         || getMonth() == 10 || getMonth() == 11))
            {
                addMonths(1);
                addDays(-31);
                if (getMonth() / 12 >= 1)
                {
                    addYears(getMonth() / 12);
                    addMonths(-12);
                }
            }
            else if (getYear() % 4 != 0 && getYear() % 100 == 0
                     && getYear() % 400 != 0 && getMonth() == 2
                     && getMonth() == 2 && getDay() > 28)
            {
                addMonths(1);
                addDays(-28);
            }
        }
        if (getMonth() == 0)
            addMonths(1);
        if (getDay() == 0)
            addDays(1);
    }

    /**
     * Adds y years to year and returns year
     * @param y number of years being added
     * @return year
     */
    public int addYears(int y)
    {
        year += y;
        return year;
    }

    /**
     * Adds m months to month and returns month
     * @param m number of months being added
     * @return month
     */
    public int addMonths(int m)
    {
        month += m;
        return month;
    }

    /**
     * Adds d days to the day and returns day
     * @param d number of days being added
     * @return day
     */
    public int addDays(int d)
    {
        day += d;
        return day;
    }

    /**
     * Returns the year
     * @return year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the month
     * @return month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the day
     * @return day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Sets the speed as v
     * @param v the speed
     */
    public void setSpeed(double v)
    {
        this.v = v;
    }

    /**
     * Returns the speed
     * @return v
     */
    public double getSpeed()
    {
        return v;
    }

    /**
     * Sets the time passing on earth
     * @param e time passing on earth
     */
    public void setEarthTime(double e)
    {
        earthT = e;
    }

    /**
     * Returns the time passing on earth
     * @return earthT
     */
    public double getEarthTime()
    {
        return earthT;
    }

    /**
     * Sets the time passing for you
     * @param y time passing for you
     */
    public void setYouTime(double y)
    {
        youT = y;
    }

    /**
     * Returns the time passing for you
     * @return youT
     */
    public double getYouTime()
    {
        return youT;
    }

    /**
     * Puts the date in a nice format
     * @return month/day/year
     */
    public String getDate()
    {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
}

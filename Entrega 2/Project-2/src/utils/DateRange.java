package utils;


public final class DateRange {
    private String _start;
    private String _stop;
    private int _start_year;
    private int _start_month;
    private int _start_day;
    private int _stop_year;
    private int _stop_month;
    private int _stop_day;
    private boolean _isNullRange;
    public DateRange(String start, String stop){
        _start = start;
        _stop = stop;
        String[] startDate = _start.split("-");
        String[] stopDate = _stop.split("-");
        _start_day = Integer.parseInt(startDate[0]);
        _start_month = Integer.parseInt(startDate[1]);
        _start_year = Integer.parseInt(startDate[2]);

        _stop_day = Integer.parseInt(stopDate[0]);
        _stop_month = Integer.parseInt(stopDate[1]);
        _stop_year = Integer.parseInt(stopDate[2]);
        _isNullRange = false;
    }

    private DateRange(){
        _isNullRange = true;
    }
    public static DateRange nullRange(){
        return new DateRange();
    }

    public boolean inRange(DateRange dateRange){
        if (_isNullRange)
            return false;
        return
                (_start_year <= dateRange._start_year && dateRange._stop_year <= _stop_year) &&
                (_start_month <= dateRange._start_month && dateRange._start_year <= _stop_month) &&
                (_start_day <= dateRange._start_day && dateRange._stop_day <= _stop_day);
    }

    public void update(String start, String stop){
        _start = start;
        _stop = stop;
        String[] startDate = _start.split("-");
        String[] stopDate = _stop.split("-");
        _start_day = Integer.parseInt(startDate[0]);
        _start_month = Integer.parseInt(startDate[1]);
        _start_year = Integer.parseInt(startDate[2]);

        _stop_day = Integer.parseInt(stopDate[0]);
        _stop_month = Integer.parseInt(stopDate[1]);
        _stop_year = Integer.parseInt(stopDate[2]);
        _isNullRange = false;
    }

    @Override
    public String toString(){
        return _start + "|" + _stop;
    }
}

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nurkulov 12/26/19
 */

public class TestConstants {

    private static final String[]     ACTUAL_DEFENDERS                =
        {"Marcos Rojo", "Harry Maguire", "Victor Nilsson-Lindelöf", "Axel Tuanzebe", "Phil Jones", "Luke Shaw", "Eric Bailly", "Timothy Fosu-Mensah", "Aaron Wan-Bissaka",
            "Alex Telles", "Brandon Williams", "Teden Mengi"};
    private static final String[]     GOALKEEPERS                     = {"David De Gea", "Sergio Romero", "Dean Henderson", "Joel Pereira", "Lee Grant"};
    private static final String[]     EXPECTED_MIDFIELDERS            =
        {"Fred", "Bruno Fernandes", "Jesse Lingard", "Paul Pogba", "Nemanja Matić", "Donny van de Beek", "Scott McTominay", "Juan Mata", "Daniel James", "Tahith Chong"};
    private static final String[]     EXPECTED_MIDFIELDER_FROM_BRAZIL = {"Fred"};
    private static final String[]     EXPECTED_ATTACKERS              = {"Marcus Rashford", "Mason Greenwood"};
    private static final String[]     EXPECTED_COACH                  = {"Gaizka Garitano"};
    private static final String[]     EXPECTED_TEAMS                  =
        {"Arsenal FC", "Aston Villa FC", "Blackburn Rovers FC", "Bolton Wanderers FC", "Chelsea FC", "Everton FC", "Fulham FC", "Liverpool FC", "Manchester City FC", "Manchester United FC",
            "Newcastle United FC", "Norwich City FC", "Queens Park Rangers FC", "Stoke City FC", "Sunderland AFC", "Tottenham Hotspur FC", "West Bromwich Albion FC", "Wigan Athletic FC",
            "Wolverhampton Wanderers FC", "Hull City AFC", "Burnley FC", "Birmingham City FC", "Leicester City FC", "Southampton FC", "Leeds United FC", "Derby County FC", "Middlesbrough FC",
            "Sheffield Wednesday FC", "Watford FC", "Charlton Athletic FC", "Ipswich Town FC", "Nottingham Forest FC", "Crystal Palace FC", "Reading FC", "Sheffield United FC", "Barnsley FC",
            "Millwall FC", "Rotherham United FC", "Bristol City FC", "Luton Town FC", "Huddersfield Town AFC", "Brighton & Hove Albion FC", "Brentford FC", "West Ham United FC", "England",
            "AFC Bournemouth", "Burton Albion FC", "Coventry City FC", "Preston North End FC", "Wycombe Wanderers FC"};
    private static final String[]     EXPECTED_SECOND_HIGHEST_SCORER  = {"Denis Cheryshev", "Cristiano Ronaldo", "Antoine Griezmann", "Romelu Lukaku", "Kylian Mbappé"};
    private static final List<String> EXPECTED_COMPETITIONS_LIST      = Stream.of(
        "WC Qualification", "Primera B Nacional", "Superliga Argentina", "Copa Liga Profesional", "Supercopa Argentina", "WC Qualification", "A League", "FFA Cup", "Erste Liga", "Bundesliga",
        "ÖFB Cup", "Playoffs 1/2", "Coupe de Belgique", "Division 1B", "Jupiler Pro League", "Playoffs II", "Supercoupe de Belgique", "LFPB", "Premier Liga", "Copa do Brasil", "Série D", "Série C",
        "Série B", "Série A", "Kupa na Bulgarija", "A PFG", "Canadian Championship", "Primera División", "Playoffs 1/2", "Supercopa de Chile", "Chinese Super League", "Liga Postobón",
        "Superliga de Colombia", "Prva Liga", "Synot Liga", "DBU Pokalen", "Superliga", "Play Offs 1/2", "Copa Pilsener Serie A", "Football League Cup", "FA Community Shield", "FA Cup",
        "National League", "League Two", "League One", "Championship", "Premier League", "Meistriliiga", "UEFA Europa League", "European Championship", "UEFA Champions League", "UEFA Women's EURO",
        "WC Qualification", "Suomen Cup", "Veikkausliiga", "Coupe de la Ligue", "Ligue 2", "Ligue 1", "Coupe de France", "Trophée des Champions", "Playoffs 1/2", "Playoffs 2/3", "DFB-Pokal",
        "Regionalliga", "3. Liga", "2. Bundesliga", "Bundesliga", "Frauen Bundesliga", "DFL Super Cup", "Greek Cup", "Super League", "Magyar Kupa", "NB I", "Úrvalsdeild", "I-League", "Ligat ha'Al",
        "Supercoppa", "Coppa Italia", "Serie C", "Serie B", "Serie A", "J.League Cup", "J. League Division 2", "J. League", "Super Cup", "Virslīga", "A Lyga", "Premier League", "Copa MX",
        "SuperCopa MX", "Liga MX", "KNVB Beker", "Jupiler League", "Eredivisie", "Johan Cruijff Schaal", "League Cup", "Premiership", "Tippeligaen", "1. divisjon", "Playoffs 1/2", "WC Qualification",
        "Liga Panameña de Fútbol", "Primera División", "Puchar Polski", "Superpuchar Polski", "Taça de Portugal", "Liga2 Cabovisão", "Primeira Liga", "Supertaça Cândido de Oliveira",
        "Premier Division", "Liga II", "Liga I", "Supercupa României", "Russian Cup", "FNL", "RFPL", "Playoffs 1/2", "Russian Super Cup", "Scottish Cup", "Championship", "Premier League",
        "Playoffs 2/3", "ABSA Premiership", "Copa America", "Copa Sudamericana", "WC Qualification", "Copa del Rey", "Segunda División", "Primera Division", "Supercopa de España", "Superettan",
        "Allsvenskan", "Playoffs 1/2", "Playoffs 2/3", "Schweizer Pokal", "Super League", "1. Lig", "Süper Lig", "TFF Süper Kupa", "Kubok Ukrainy", "Premier Liha", "Playoffs 1/2",
        "Superkubok Ukrainy", "MLS", "Primera División", "Supercopa Uruguaya", "Primera División", "V-League", "Welsh Premier League", "FIFA World Cup").collect(Collectors.toList());

    public static String[] getActualDefenders() {
        return ACTUAL_DEFENDERS;
    }

    public static String[] getGOALKEEPERS() {
        return GOALKEEPERS;
    }

    public static String[] getExpectedMidfielders() {
        return EXPECTED_MIDFIELDERS;
    }

    public static String[] getExpectedMidfielderFromBrazil() {
        return EXPECTED_MIDFIELDER_FROM_BRAZIL;
    }

    public static String[] getExpectedAttackers() {
        return EXPECTED_ATTACKERS;
    }

    public static String[] getExpectedCoach() {
        return EXPECTED_COACH;
    }

    public static String[] getExpectedTeams() {
        return EXPECTED_TEAMS;
    }

    public static String[] getExpectedSecondHighestScorer() {
        return EXPECTED_SECOND_HIGHEST_SCORER;
    }

    public static List<String> getExpectedCompetitionsList() {
        return EXPECTED_COMPETITIONS_LIST;
    }
}

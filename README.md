# footballRank

This project provides your team standing based on the standing data fetched from the source https://apifootball.com/.

API Signature : http://localhost:8080/api/v1/getStanding?country_name=Argentina&league_name=Primera C&team_name=Dep. Merlo

Mandatory Request Params : Country Name , League Name & Team Name

We are loading country cache (map of country name to country id) bean at the application load.

Response Object : {
  country id : "1",
  country_name : "XYZ",
  league_id :"2",
  league_name : "ABC",
  team_id : "3",
  team_name : "QWE",
  overall_league_position : "4"
}

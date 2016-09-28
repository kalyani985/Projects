using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Movie_Team7.SMB_team7
{
    public partial class StaffCheckTran : System.Web.UI.Page
    {
        SMB_team7_dbEntities2 ctx = new SMB_team7_dbEntities2();
        StaffCheckTranController tran = new StaffCheckTranController();
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack)
            {
                LerrbookingID.Text = "";
                //DDLmovieName.SelectedIndex = 0;
                
            }
            
            var query = from x in ctx.MovieSchedules select new { x.movieName, x.cinemaName, x.timeslot, x.date };
            GridView1.DataSource = query.ToList();
            GridView1.DataBind();
        }

        protected void staffCheckDate_Click(object sender, ImageClickEventArgs e)
        {
            Calendar1.Visible = true;
        }

        protected void staffTranSearch_Click(object sender, EventArgs e)
        {
           TransViw view = new TransViw();
           BookingInfo b = new BookingInfo();

            //BOOKING ID


           
           if (TBbookingID.Text != "")
           {
                    

                    int bookingID = Convert.ToInt32(TBbookingID.Text);
                    String err = tran.MyValidate(bookingID);
                    LerrbookingID.Text = err;
                    List<TransViw> TR = tran.findRecord(bookingID);
                    GridView1.DataSource = TR;
                    GridView1.DataBind();
           }

        //MOVIE NAME

           else if (DDLmovieName.SelectedItem.Text != "")
           {
               String movie = DDLmovieName.SelectedItem.Text;
               List<TransViw> TR = tran.findMovieRecord(movie);
               GridView1.DataSource = TR;
               GridView1.DataBind();           


           }
           


           //CINEMA NAME
           else if (DDLcinemaName.SelectedItem.Text != "")
           {
               String cinema = DDLcinemaName.SelectedItem.Text;
               List<TransViw> TR = tran.findCinemaRecord(cinema);
               GridView1.DataSource = TR;
               GridView1.DataBind();
           }


         //CINEMANAME,MOVIE NAME, DATE,TIMESLOT
           else
           {
               if (DDLcinemaName.SelectedItem.Text != "" && DDLmovieName.SelectedItem.Text != "" && DDLtimeSlot.SelectedItem.Text != "" && TBdate.Text != "")
               {
                   String movie = DDLmovieName.SelectedItem.Text;
                   String cinema = DDLcinemaName.SelectedItem.Text;
                   String date = TBdate.Text;
                   int timeslot = Convert.ToInt32(DDLtimeSlot.SelectedItem.Text);
                   List<TransViw> TR = tran.findRecordall(movie, cinema, date, timeslot);
                   GridView1.DataSource = TR;
                   GridView1.DataBind();
               }


               else if (DDLcinemaName.SelectedItem.Text == "" && DDLmovieName.SelectedItem.Text == "" && DDLtimeSlot.SelectedItem.Text == "" && TBdate.Text == "")
                   LerrbookingID.Text = "Select Movie,Cinema,Date,TImeSlot Option";


               else
                   LerrbookingID.Text = "Give BookingID";
           }
           DDLmovieName.ClearSelection();
        }

        protected void Calendar1_SelectionChanged(object sender, EventArgs e)
        {
            TBdate.Text = Calendar1.SelectedDate.ToShortDateString();
            Calendar1.Visible = false;
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Movie_Team7.SMB_team7
{
    public partial class View_Member : System.Web.UI.Page
    {
        SMB_team7_dbEntities2 ctx = new SMB_team7_dbEntities2();
        protected void Page_Load(object sender, EventArgs e)
        {
            //var query =
            //       from p in ctx.BookingInfoes
            //       group p by p.memberID into mg
            //       select new { MemberID = mg.Key, NoofTicket = mg.Sum(p => p.noOfTicket), TotalPrice = mg.Sum(p => p.totalPrice)};
            //GridView1.DataSource = query.ToList();
            //GridView1.DataBind();
           

        }
    }
}
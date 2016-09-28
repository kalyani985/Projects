<%@ Page Title="" Language="C#" MasterPageFile="~/cinema.Master" AutoEventWireup="true" CodeBehind="Booking.aspx.cs" Inherits="Movie_Team7.SMB_team7.Booking" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
     <style type="text/css">
    .auto-style1 {
        width: 213px;
    }
    .auto-style2 {
        width: 381px;
    }
         .auto-style3 {
             width: 382px;
         }
     </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
     <form id="form1" runat="server">
    <table class="movies">
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; You currently are booking:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:Button ID="bookRuturnButton" runat="server" Text="Return" />
            </td>
        </tr>
        <tr>
            <td>
                <table class="movies">
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <asp:Label ID="bookName" runat="server" Text="Label"></asp:Label>
                        </td>
                        <td>Cinema:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <asp:Label ID="bookCinema" runat="server" Text="Label"></asp:Label>
                        </td>
                        <td>Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <asp:Label ID="bookDate" runat="server" Text="Label"></asp:Label>
                        </td>
                        <td class="auto-style1">
                            <asp:Label ID="Label1" runat="server" Text="   "></asp:Label>
                            Timeslot:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <asp:Label ID="bookTimeslot" runat="server" Text="Label"></asp:Label>
                        </td>
                        <td class="auto-style1">Hall Number:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <asp:Label ID="bookHall" runat="server" Text="Label"></asp:Label>
&nbsp;&nbsp; </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table class="movies">
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Please select&nbsp; seats:&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<asp:CheckBox ID="A1" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A2" runat="server" OnCheckedChanged="A2_CheckedChanged" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A3" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A4" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A5" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A6" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A7" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A8" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A9" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A10" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="A11" runat="server" />
&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="A12" runat="server" />
                <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="B1" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B2" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B3" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B4" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B5" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B6" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B7" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B8" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B9" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B10" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="B11" runat="server" />
&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="B12" runat="server" />
                <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="C1" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="C2" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="C3" runat="server" />
&nbsp;
                <asp:CheckBox ID="C4" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="C5" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="C6" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="C7" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="C8" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="C9" runat="server" />
&nbsp;
                <asp:CheckBox ID="C10" runat="server" />
&nbsp;
                <asp:CheckBox ID="C11" runat="server" />
&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="C12" runat="server" />
                <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="D1" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="D2" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="D3" runat="server" />
&nbsp;
                <asp:CheckBox ID="D4" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="D5" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="D6" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="D7" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="D8" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="D9" runat="server" />
&nbsp;
                <asp:CheckBox ID="D10" runat="server" />
&nbsp;
                <asp:CheckBox ID="D11" runat="server" />
&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="D12" runat="server" />
&nbsp;<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="E1" runat="server"  />
&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="E2" runat="server"  />
&nbsp;&nbsp;
                <asp:CheckBox ID="E3" runat="server"  />
&nbsp;
                <asp:CheckBox ID="E4" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="E5" runat="server" />
&nbsp;&nbsp;
                <asp:CheckBox ID="E6" runat="server"  />
&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="E7" runat="server"  />
&nbsp;&nbsp;
                <asp:CheckBox ID="E8" runat="server"  />
&nbsp;&nbsp;
                <asp:CheckBox ID="E9" runat="server"  />
&nbsp;
                <asp:CheckBox ID="E10" runat="server"  />
&nbsp;&nbsp;
                <asp:CheckBox ID="E11" runat="server"  />
&nbsp;&nbsp;&nbsp;
                <asp:CheckBox ID="E12" runat="server"  />
            </td>
        </tr>
    </table>
&nbsp;<table class="movies">
        <tr>
            <td class="auto-style2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantity:&nbsp;&nbsp;
                <asp:Label ID="bookQTY" runat="server" Text="Label"></asp:Label>
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;Price:&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:Label ID="bookPrice" runat="server" Text="Label"></asp:Label>
            </td>
        </tr>
    </table>
         <table class="container">
             <tr>
                 <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Price&nbsp; Type&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;&nbsp;
                     <asp:DropDownList ID="DropDownList1" runat="server" Height="16px" Width="164px">
                     </asp:DropDownList>
                     <br />
                 </td>
                 <td>&nbsp;</td>
             </tr>
         </table>
    <table class="movies">
        <tr>
            <td class="auto-style3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<asp:Button ID="bookGuestButton" runat="server" Text="confirm " Width="122px" />
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:Button ID="bookCancelButton" runat="server" Text="Cancel" Width="125px" />
            </td>
        </tr>
    </table>
</form>
</asp:Content>

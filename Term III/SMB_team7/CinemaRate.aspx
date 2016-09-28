<%@ Page Title="" Language="C#" MasterPageFile="~/staff.Master" AutoEventWireup="true" CodeBehind="CinemaRate.aspx.cs" Inherits="Movie_Team7.SMB_team7.CinemaRate" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .auto-style1 {
            width: 576px;
        }
        .auto-style2 {
            width: 202px;
        }
        .auto-style3 {
            margin-left: 26;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <form id="form1" runat="server">
        <table class="container">
            <tr>
                <td class="auto-style1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Movie Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:DropDownList ID="rateMovie" runat="server" Height="17px" Width="184px">
                    </asp:DropDownList>
                    <br />
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<asp:Button ID="rateSearch" runat="server" Text="Search" />
                    <br />
                </td>
            </tr>
        </table>
        <table class="container">
            <tr>
                <td class="auto-style2">&nbsp;</td>
                <td>&nbsp;&nbsp;<asp:GridView ID="GridView1" runat="server" CssClass="auto-style3" Width="583px">
                    </asp:GridView>
                </td>
            </tr>
        </table>
    </form>
</asp:Content>

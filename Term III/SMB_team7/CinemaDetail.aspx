<%@ Page Title="" Language="C#" MasterPageFile="~/cinema.Master" AutoEventWireup="true" CodeBehind="CinemaDetail.aspx.cs" Inherits="Movie_Team7.SMB_team7.CinemaDetail" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .auto-style1 {
            width: 297px;
            height: 18px;
        }
        .auto-style2 {
            height: 18px;
        }
        .auto-style3 {
            width: 206px;
        }
        .auto-style4 {
            margin-left: 39;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <form id="form1" runat="server">
        <table class="container">
            <tr>
                <td class="auto-style1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
                    <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
                </td>
                <td class="auto-style2">
                    <table class="container">
                        <tr>
                            <td>&nbsp; &nbsp;&nbsp;&nbsp; Cinema Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;
                                <asp:Label ID="Label2" runat="server" Text="Label"></asp:Label>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cinema Address&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;
                                <asp:Label ID="Label3" runat="server" Text="Label"></asp:Label>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Contact Number&nbsp; :&nbsp;&nbsp;&nbsp; &nbsp;
                                <asp:Label ID="Label4" runat="server" Text="Label"></asp:Label>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cinema Description:&nbsp;&nbsp;
                                <asp:Label ID="Label5" runat="server" Text="Label"></asp:Label>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <table class="container">
            <tr>
                <td class="auto-style3">&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TreeView ID="TreeView1" runat="server">
                    </asp:TreeView>
                </td>
                <td>
                    <asp:GridView ID="GridView1" runat="server" CssClass="auto-style4" Width="559px">
                        <Columns>
                            <asp:ButtonField ButtonType="Button" CommandName="Select" Text="Book" />
                        </Columns>
                    </asp:GridView>
                </td>
            </tr>
        </table>
    </form>
</asp:Content>

namespace UserManagementApi.Model;
using System;
using System.ComponentModel.DataAnnotations;
public class User
{
    public int userid { get; set; }

    [Required]
    public string username { get; set; } = "";

    [Required]
    public string course { get; set; } = "";

    [Required]
    public string purchasedate { get; set; } = "";
}
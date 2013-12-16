
function UserListManager(listClassName, jsonMapping, itemTemplate, listTemplate) {
    this.listClassName = listClassName;
    this.jsonMapping = jsonMapping;
    this.listTemplate = listTemplate;
    this.itemTemplate = itemTemplate;
    this.selectedUserIds = new Array();

    this.SetUserList = function(userList){
      for(user in userList){
        var list = document.getElementsByClassName(listClassName)


      }
    }
}
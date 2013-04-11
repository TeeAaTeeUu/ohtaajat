description 'User can print books/..s/..s in cleartext'

scenario "user can print books in cleartext", {
    given 'Kirjojen listaus selected'
    when 'link is pressed'
    then 'book list is printed in cleartext'
          
}
description 'User can create a new book/../..'

scenario "user can create new book", {
    given 'Kirjan luonti is selected'
    when 'valid book information are given'
    then 'new book is created'
}
          

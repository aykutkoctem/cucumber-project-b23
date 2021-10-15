Feature: Homework


Scenario: User should see side bar tabs as expected
Given we are at web order login page
When we provide valid credentials
Then we should see all order page
Then side bar tabs should be as below
| View all orders   |
| View all products |
| Order             |

  Scenario: User should see product table as expected
    Given we are at web order login page
    And we provide valid credentials
    When we select "View all products" tab from sidebar
    Then we should see table with below content
    # for the sake of simplicity below table is modified to match exactly to actual table
      | Product name| Price | Discount |
      | MyMoney     | $100  | 8%       |
      | FamilyAlbum | $80   | 15%      |
      | ScreenSaver | $20   | 10%      |
@homework
  Scenario: User should see correct product price generated
    Given we are at web order login page
    And we provide valid credentials
    When we select "Order" tab from sidebar
    Then we should see three section as below
      |Product Information|
      |Address Information|
      |Payment Information|

    And select each product from dropdown should change the unit price accordingly
      | ScreenSaver | 20   |
      | MyMoney     | 100  |
      | FamilyAlbum | 80   |

      # you need to loop to select each item and assert unit price box

  Scenario: User should see correct product price and discount generated with total price
    Given we are at web order login page
    And we provide valid credentials
    When we select "Order" tab from sidebar
    Then selecting blow product and quantity should show correct total and discount
      | Product     | Price | Quantity | Discount | Total |
      | ScreenSaver | 20    | 5        | 0        | 100   |
      | MyMoney     | 100   | 5        | 0        | 500   |
      | FamilyAlbum | 80    | 5        | 0        | 400   |
      | ScreenSaver | 20    | 10       | 10       | 180   |
      | MyMoney     | 100   | 10       | 8        | 920   |
      | FamilyAlbum | 80    | 10       | 15       | 680   |
      # you need to loop to select each item and assert discount box and total box
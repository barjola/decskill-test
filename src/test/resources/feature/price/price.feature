Feature: Search prices

  Scenario Outline: Search price that exist
    Given A '<productId>', '<brandId>' and '<date>'
    When I query the price
    Then I get the price response '<json>' with status '200'

    Examples:
      | productId | brandId | date                          | json           |
      | 35455     | 1       | 2020-06-14T10:00:00.000+01:00 | response1.json |
      | 35455     | 1       | 2020-06-14T16:00:00.000+01:00 | response2.json |
      | 35455     | 1       | 2020-06-14T21:00:00.000+01:00 | response3.json |
      | 35455     | 1       | 2020-06-15T10:00:00.000+01:00 | response4.json |
      | 35455     | 1       | 2020-06-16T21:00:00.000+01:00 | response5.json |

  Scenario Outline: Search price that does not exist
    Given A '<productId>', '<brandId>' and '<date>'
    When I query the price
    Then The system throws an error and responds with status 404

    Examples:
      | productId | brandId | date                          |
      | 99999     | 1       | 2020-06-14T10:00:00.000+01:00 |
      | 35455     | 99      | 2020-06-14T10:00:00.000+01:00 |
      | 35455     | 1       | 9999-06-14T10:00:00.000+01:00 |

  Scenario Outline: Search price with incorrect parameters
    Given A '<productId>', '<brandId>' and '<date>'
    When I query the price
    Then The system throws an error and responds with status 400

    Examples:
      | productId | brandId | date                          |
      | null      | 1       | 2021-06-14T10:00:00.000+01:00 |
      | 35455     | null    | 2021-06-14T10:00:00.000+01:00 |
      | 35455     | 1       | null                          |
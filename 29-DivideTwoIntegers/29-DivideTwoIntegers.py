# Last updated: 14/07/2026, 16:17:31
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        # Constants for 32-bit signed integer limits
        MAX_INT = 2147483647
        MIN_INT = -2147483648

        # Handle overflow edge case
        if dividend == MIN_INT and divisor == -1:
            return MAX_INT

        # Determine if the final result is negative
        is_negative = (dividend < 0) ^ (divisor < 0)

        # Work with positive absolute values
        abs_dividend = abs(dividend)
        abs_divisor = abs(divisor)

        quotient = 0

        # Perform bitwise exponential subtraction
        while abs_dividend >= abs_divisor:
            current_divisor = abs_divisor
            num_mapping = 1

            # Shift left to double the divisor as much as possible
            while abs_dividend >= (current_divisor << 1):
                current_divisor <<= 1
                num_mapping <<= 1
            abs_dividend -= current_divisor
            quotient += num_mapping
        return -quotient if is_negative else quotient          
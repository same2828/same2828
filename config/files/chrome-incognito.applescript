-- Automator > Application > Run AppleScript > Save as App

on run {input, parameters}
	
	if application "Google Chrome" is running then
		tell application "Google Chrome" to make new window with properties {mode:"incognito"}
	else
		-- do shell script "open -a /Applications/Google\\ Chrome.app --args --incognito"
		do shell script "open -na /Applications/Google\\ Chrome.app --args --incognito"
    -- Below is NOT performant (hangs in background) after exported
    -- do shell script "/Applications/'Google Chrome.app'/Contents/MacOS/'Google Chrome' --incognito"
	end if
	
	tell application "Google Chrome" to activate
	
	return input
end run